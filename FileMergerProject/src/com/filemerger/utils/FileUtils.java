package com.filemerger.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    private FileUtils() {}   // Utility class — no instances
    public static String readFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(filePath);

        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public static void appendToFile(String filePath, String content) throws IOException {
        File file = new File(filePath);

        // Create parent directories if missing
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8))) {
            writer.write(content);
            writer.flush();
        }
    }

    public static void clearFile(String filePath) throws IOException {
        File file = new File(filePath);

        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            boolean dirCreated = file.getParentFile().mkdirs();
            if (dirCreated) {
                System.out.println("[FileUtils] Created directory: "
                                   + file.getParentFile().getAbsolutePath());
            }
        }

        if (!file.exists()) {
            boolean fileCreated = file.createNewFile();
            if (fileCreated) {
                System.out.println("[FileUtils] Created new file: "
                                   + file.getAbsolutePath());
            }
        }

        try (FileWriter fw = new FileWriter(file, false)) {
            fw.write("");
        }
        System.out.println("[FileUtils] Cleared destination file: "
                           + file.getAbsolutePath());
    }
}
