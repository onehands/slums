package com.slums.hands.jx.file;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/8 16:27
 * @version: 1.0
 */
public class FileWriteTest {
    private static final String finalName = "src/test/resources/test.txt";
    private static final String newFinalName = "src/test/resources/test_new.txt";

    @Test
    public void transWithBuffer() throws IOException {
        File writeFile = new File(newFinalName);
        if (writeFile.exists()) {
            writeFile.delete();
        }
        BufferedInputStream bfs = new BufferedInputStream(new FileInputStream(finalName));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFinalName));
        byte[] bytes = new byte[1024 * 1024];
        int len = -1;
        while ((len = bfs.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
//        bos.flush();
    }

    @Test
    public void transWithNIO() throws IOException {
        File writeFile = new File(newFinalName);
        if (writeFile.exists()) {
            writeFile.delete();
        }
        RandomAccessFile read = new RandomAccessFile(finalName, "rw");
        RandomAccessFile write = new RandomAccessFile(newFinalName, "rw");

        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();

        ByteBuffer bf = ByteBuffer.allocate(1024 * 1024);

        while (readChannel.read(bf) > 0) {
            bf.flip();
            writeChannel.write(bf);
            bf.clear();
        }
        readChannel.close();
        writeChannel.close();
    }

    @Test
    public void transWithNIO2() throws IOException {
        File writeFile = new File(newFinalName);
        if (writeFile.exists()) {
            writeFile.delete();
            writeFile.createNewFile();
        }
        RandomAccessFile read = new RandomAccessFile(finalName, "rw");
        RandomAccessFile write = new RandomAccessFile(newFinalName, "rw");
        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();
//        readChannel.transferTo(0, read.length(), writeChannel);
        writeChannel.transferFrom(readChannel, 0, read.length());
    }


}
