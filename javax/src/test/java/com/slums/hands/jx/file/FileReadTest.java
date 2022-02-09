package com.slums.hands.jx.file;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/2/8 14:56
 * @version: 1.0
 */
public class FileReadTest {
    private static final String fileName = "src/test/resources/test.txt";

    @Test
    public void testReadByFiles() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println("switch :");
        Stream<String> linesStream = Files.lines(Paths.get(fileName));
        lines = linesStream.sorted().distinct().collect(Collectors.toList());
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println("switch :");
        byte[] bytes = Files.readAllBytes(Paths.get(fileName));
        System.out.println(new String(bytes));

    }

    @Test
    public void testReadByScanner() throws FileNotFoundException {
        FileReader fr = new FileReader(fileName);
        Scanner sc = new Scanner(fr);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }


    @Test
    public void testReadByReader() throws IOException {
        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
        }

        System.out.println("read by classpath");
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("test.txt"))))) {
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);

            }
        }
    }
}
