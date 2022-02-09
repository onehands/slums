package com.slums.hands.io.block;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/8 17:23
 * @version: 1.0
 */
public class Server {
    private static final String fileName = "D:/test_net.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        ServerSocketChannel ssc = ServerSocketChannel.open();
        FileChannel writeChannel = FileChannel.open(Paths.get(fileName), StandardOpenOption.WRITE);
        ssc.bind(new InetSocketAddress(23333));
        SocketChannel sc = ssc.accept();
        ByteBuffer bf = ByteBuffer.allocate(1024);
        while (sc.read(bf) > 0) {
            bf.flip();
            writeChannel.write(bf);
            bf.clear();
        }
    }
}
