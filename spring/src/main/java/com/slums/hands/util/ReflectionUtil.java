package com.slums.hands.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.SystemPropertyUtils;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
public class ReflectionUtil {

    private static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";
    private static final DateTimeFormatter DATE_TIME_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static <T> Set<Class<T>> scanAnnotatedWith(String basePackage, Class clazz) {
        Set<Class<T>> candidates = new LinkedHashSet<>();
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
        try {
            String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                    resolveBasePackage(basePackage) + '/' + DEFAULT_RESOURCE_PATTERN;
            Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);

            for (Resource resource : resources) {
                if (resource.isReadable()) {
                    try {
                        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
                        Class candidate = Class.forName(metadataReader.getClassMetadata().getClassName());
                        Annotation annotation = candidate.getAnnotation(clazz);
                        if (null != annotation) {
                            candidates.add(candidate);
                        }
                    } catch (Throwable ex) {
                        throw new RuntimeException(
                                "Failed to read candidate component class: " + resource, ex);
                    }
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("I/O failure during classpath scanning", ex);
        }
        return candidates;
    }

    public static Map<String, String> extractField(Object model) {
        Map<String, String> paramMap = new LinkedHashMap<>();
        if (null == model) {
            return paramMap;
        }
        try {
            for (PropertyDescriptor propertyDescriptor :
                    Introspector.getBeanInfo(model.getClass()).getPropertyDescriptors()) {
                String propertyName = propertyDescriptor.getName();
                if (null != propertyDescriptor.getReadMethod()) {
                    Object fieldValue = propertyDescriptor.getReadMethod().invoke(model);
                    paramMap.put(propertyName, getStringValue(fieldValue));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return paramMap;
    }


    private static String getStringValue(Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof LocalDateTime) {
            return ((LocalDateTime) object).format(DATE_TIME_PATTERN);
        } else if (object instanceof LocalDate) {
            return ((LocalDate) object).format(DATE_PATTERN);
        } else {
            return String.valueOf(object);
        }
    }

    private static String resolveBasePackage(String basePackage) {
        return ClassUtils.convertClassNameToResourcePath(SystemPropertyUtils.resolvePlaceholders(basePackage));
    }
}
