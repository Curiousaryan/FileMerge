package com.filemerger.main;

import com.filemerger.config.AppConfig;
import com.filemerger.reader.FileReaderThread;
import com.filemerger.utils.FileUtils;
import com.filemerger.writer.SynchronizedFileWriter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        printBanner();

        try {
            FileUtils.clearFile(AppConfig.DESTINATION_FILE);
        } catch (IOException e) {
            System.err.println("[Main] Could not clear destination: " + e.getMessage());
            return;
        }

        SynchronizedFileWriter sharedWriter =
                new SynchronizedFileWriter(AppConfig.DESTINATION_FILE);


        FileReaderThread thread1 = new FileReaderThread(
                AppConfig.THREAD_1_NAME,
                AppConfig.SOURCE_FILE_1,
                sharedWriter);

        FileReaderThread thread2 = new FileReaderThread(
                AppConfig.THREAD_2_NAME,
                AppConfig.SOURCE_FILE_2,
                sharedWriter);

        System.out.println("\n[Main] Launching both threads simultaneously...\n");
        long startTime = System.currentTimeMillis();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("[Main] Interrupted while waiting for threads.");
        }

        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("\n" + "─".repeat(60));
        System.out.println("  ✅  MERGE COMPLETE!");
        System.out.println("  📄  Output File   : " + AppConfig.DESTINATION_FILE);
        System.out.println("  ✍️   Total Writes  : " + sharedWriter.getWriteCount());
        System.out.println("  ⏱️   Time Taken    : " + elapsed + " ms");
        System.out.println("─".repeat(60));
        System.out.println("\n  Open '" + AppConfig.DESTINATION_FILE
                           + "' to see the merged content!\n");
    }

    private static void printBanner() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║        FILE MERGER — Threads + File Handling Demo        ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║  Source 1 : " + padRight(AppConfig.SOURCE_FILE_1, 45) + "║");
        System.out.println("║  Source 2 : " + padRight(AppConfig.SOURCE_FILE_2, 45) + "║");
        System.out.println("║  Output   : " + padRight(AppConfig.DESTINATION_FILE, 45) + "║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println();
    }

    private static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
