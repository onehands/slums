package com.slums.hands.io.block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/8 17:19
 * @version: 1.0
 */
public class Client {
    private static final String fileName = "D:/id_rsa";

    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 23333));
        sc.configureBlocking(false);


        FileChannel read = FileChannel.open(Paths.get(fileName));
        ByteBuffer bf = ByteBuffer.allocate(1024);
        while (read.read(bf) != -1) {
            bf.flip();
            sc.write(bf);
            bf.clear();
        }
        sc.close();
        read.close();
    }
}
