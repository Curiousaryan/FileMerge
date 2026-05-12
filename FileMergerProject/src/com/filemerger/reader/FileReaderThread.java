package com.filemerger.reader;

import com.filemerger.model.FileContent;
import com.filemerger.utils.FileUtils;
import com.filemerger.writer.SynchronizedFileWriter;

import java.io.IOException;

public class FileReaderThread extends Thread {

    private final String              sourceFilePath;
    private final SynchronizedFileWriter writer;

    public FileReaderThread(String threadName,
                            String sourceFilePath,
                            SynchronizedFileWriter writer) {
        super(threadName);                      // Sets Thread.getName()
        this.sourceFilePath = sourceFilePath;
        this.writer         = writer;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Started → Reading: " + sourceFilePath);

        try {
            String rawContent = FileUtils.readFile(sourceFilePath);

            System.out.println("[" + threadName + "] Finished reading '"
                               + sourceFilePath + "' ("
                               + rawContent.length() + " chars)");

            FileContent fileContent = new FileContent(
                    sourceFilePath, rawContent, threadName);

            writer.writeToDestination(fileContent);

        } catch (IOException e) {
            System.err.println("[" + threadName + "] ERROR reading file: "
                               + e.getMessage());
        }

        System.out.println("[" + threadName + "] Terminated.");
    }
}
