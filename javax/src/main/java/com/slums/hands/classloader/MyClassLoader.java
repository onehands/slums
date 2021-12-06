package com.slums.hands.classloader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/11/2 10:55
 * @version: 1.0
 */
public class MyClassLoader extends ClassLoader {
    private byte[] bytes;
    private Map<String, Class> cacheMap = new HashMap<>();
    private HashMap<String, URL> resources = new HashMap<>();

    public MyClassLoader(byte[] bytes, ClassLoader classLoader) {
        super(MyClassLoader.class.getClassLoader());
        this.bytes = bytes;
        initData();
    }

    @Override
    protected Class<?> findClass(String name) {
        if (cacheMap.containsKey(name)) {
            return cacheMap.get(name);
        } else {
            try {
                return findSystemClass(name);
            } catch (ClassNotFoundException e) {
                try {
                    return this.getParent().loadClass(name);
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        }
        return findClass(name);
    }

    private void initData() {
        try {
            addClassesFromStream(new JarInputStream(new ByteArrayInputStream(bytes)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addClassesFromStream(JarInputStream jarInputStream) throws IOException {
        try {
            JarEntry entry = jarInputStream.getNextJarEntry();
            while (entry != null) {
                String name = entry.getName();
                boolean isFile = !entry.isDirectory();
                boolean isJar = name.endsWith(".jar");
                boolean isClass = name.endsWith(".class");

                if (isClass) {
                    String className = pathToClassName(name);
                    byte[] classData = readCurrentJarEntry(jarInputStream);
                    if (!cacheMap.containsKey(className)) {
                        try {
                            //先从父加载器
                            cacheMap.put(className, getParent().loadClass(className));
                        } catch (ClassNotFoundException e) {
                            //父加载器里不存在
                            cacheMap.put(className, defineClass(className, classData, 0, classData.length));
                        }

                    }
                } else if (isJar) {
                    byte[] jarData = readCurrentJarEntry(jarInputStream);
                    ByteArrayInputStream byteInputStream = new ByteArrayInputStream(jarData);
                    addClassesFromStream(new JarInputStream(byteInputStream));
                } else if (isFile) {
                    byte[] fileData = readCurrentJarEntry(jarInputStream);
                    addResource(name, fileData);
                }

                entry = jarInputStream.getNextJarEntry();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public URL getResource(String name) {
        System.out.println("Resource returned: " + name);
        return resources.get(name);
    }

    @Override
    public InputStream getResourceAsStream(String name) {
        InputStream result = null;
        URL url = getResource(name);
        if (url != null) {
            try {
                result = url.openStream();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        return findClass(className);
    }

    public void addResource(String name, byte[] data) {
        try {

            URL url =
                    new URL("inputstream", "", 0, name, new InputStreamURLStreamHandler(new ByteArrayInputStream(data)));

            resources.put(name, url);

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }

    public static String pathToClassName(String path) {
        return path.substring(0, path.length() - 6).replace("/", ".");
    }

    public static byte[] readCurrentJarEntry(JarInputStream jarInStream) throws IOException {
        // read the whole contents of the
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int len;
        while ((len = jarInStream.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        return out.toByteArray();
    }
}
