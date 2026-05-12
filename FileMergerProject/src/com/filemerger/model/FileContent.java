package com.filemerger.model;

public class FileContent {

    private final String fileName;
    private final String content;
  private final String readByThread;
   public FileContent(String fileName, String content, String readByThread) {
        this.fileName     = fileName;
        this.content      = content;
        this.readByThread = readByThread;
    }

    public String getFileName()     { return fileName;     }
    public String getContent()      { return content;      }
    public String getReadByThread() { return readByThread; }

    @Override
    public String toString() {
        return "FileContent{" +
               "file='"       + fileName     + '\'' +
               ", readBy='"   + readByThread + '\'' +
               ", length="    + content.length()    +
               '}';
    }
}
