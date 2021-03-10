package com.zhdanko.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Collectors;

public class OperationWithFile {
    public static void writeToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            for (int i = 0; i < 20; i++) {
                String str = Integer.toString((int) (Math.random() * 10));
                writer.write(str);
                writer.write(System.lineSeparator());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printNumbers(String filename) throws IOException {
        System.out.println(Files.lines(Path.of(filename)).filter(Objects::nonNull).collect(Collectors.joining(", ")));
    }

    public static double average(String filename) throws IOException {
        final double sum = Files.lines(Path.of(filename)).filter(Objects::nonNull).mapToInt(Integer::valueOf).sum();
        return sum / Files.lines(Path.of(filename)).filter(Objects::nonNull).mapToInt(Integer::valueOf).count();
    }

    public static void printFiles(String path) {
        File folder = new File(path);
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            System.out.println(file.getName());
        }
    }
}
