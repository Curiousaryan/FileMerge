package com.filemerger.writer;

import com.filemerger.config.AppConfig;
import com.filemerger.model.FileContent;
import com.filemerger.utils.FileUtils;

import java.io.IOException;

public class SynchronizedFileWriter {

    private final String destinationPath;
    private int writeCount = 0;   // Tracks how many threads have written

    public SynchronizedFileWriter(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    public void writeToDestination(FileContent fileContent) {

        synchronized (this) {

            String threadName = Thread.currentThread().getName();
            System.out.println("\n[LOCK ACQUIRED] by → " + threadName);
            System.out.println("[Writing]  " + fileContent.getFileName()
                               + "  (read by: " + fileContent.getReadByThread() + ")");

            try {
                String separator = String.format(
                        AppConfig.SECTION_SEPARATOR, threadName);

                String block = separator + fileContent.getContent();

                Thread.sleep(300);

                FileUtils.appendToFile(destinationPath, block);

                writeCount++;
                System.out.println("[DONE]     Write #" + writeCount
                                   + " complete by → " + threadName);

            } catch (IOException e) {
                System.err.println("[ERROR] Write failed by " + threadName
                                   + " : " + e.getMessage());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("[INTERRUPTED] " + threadName);
            }

            System.out.println("[LOCK RELEASED] by → " + threadName);
        }
    }

    public int getWriteCount() { return writeCount; }
}
