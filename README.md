# 📂 FileMerge - Multithreaded File Merger in Java

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk)
![Threads](https://img.shields.io/badge/Multithreading-Enabled-blue?style=for-the-badge)
![File I/O](https://img.shields.io/badge/File-I/O-green?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-lightgrey?style=for-the-badge)

A Java application demonstrating **multithreading**, **thread synchronization**, and **file handling** by merging multiple text files into a single destination file safely and efficiently.

The project creates multiple reader threads that read different source files concurrently while a synchronized writer ensures that data is written to the destination file without race conditions or data corruption.

---

# 🚀 Features

- ✅ Multithreaded file reading
- ✅ Thread-safe file writing
- ✅ Synchronized resource sharing
- ✅ Clean package-based architecture
- ✅ Cross-platform file path configuration
- ✅ Console logging for thread execution
- ✅ Automatic output file generation

---

# 🏗 Architecture

```
                +-------------------+
                |     Main Class    |
                +---------+---------+
                          |
          --------------------------------
          |                              |
          ▼                              ▼
 FileReaderThread-1            FileReaderThread-2
          |                              |
          |                              |
          ------------+-------------------
                      |
                      ▼
        SynchronizedFileWriter
                      |
                      ▼
              destination.txt
```

The application launches multiple threads simultaneously.

Each thread:

- Reads one source file.
- Creates a `FileContent` object.
- Sends the content to a shared synchronized writer.

The writer uses Java's `synchronized` keyword to ensure only one thread writes to the destination file at a time.

---

# 📁 Project Structure

```
FileMergerProject
│
├── resources
│   ├── source1.txt
│   ├── source2.txt
│   └── destination.txt
│
└── src
    └── com.filemerger
        ├── config
        │     └── AppConfig.java
        │
        ├── main
        │     └── Main.java
        │
        ├── model
        │     └── FileContent.java
        │
        ├── reader
        │     └── FileReaderThread.java
        │
        ├── writer
        │     └── SynchronizedFileWriter.java
        │
        └── utils
              └── FileUtils.java
```

---

# ⚙ Technologies Used

- Java
- Java Threads
- Synchronization
- File I/O
- BufferedReader
- BufferedWriter
- Object-Oriented Programming

---

# 💡 Core Java Concepts Demonstrated

- Thread Creation
- Thread Lifecycle
- Thread Synchronization
- Shared Resource Management
- File Reading
- File Writing
- Exception Handling
- Package Organization
- Utility Classes
- Configuration Management

---

# 🔄 Workflow

```
Application Starts
        │
        ▼
Clear Destination File
        │
        ▼
Create Shared Writer
        │
        ▼
Launch Reader Threads
        │
        ▼
Each Thread Reads File
        │
        ▼
Acquire Synchronization Lock
        │
        ▼
Write Data to Output File
        │
        ▼
Release Lock
        │
        ▼
Merge Complete
```

---

# ▶ Running the Project

## Clone Repository

```bash
git clone https://github.com/Curiousaryan/FileMerge.git
```

## Open Project

Open the project in:

- IntelliJ IDEA
- Eclipse
- VS Code

---

## Compile

```bash
javac src/com/filemerger/**/*.java
```

---

## Run

```bash
java com.filemerger.main.Main
```

---

# 📄 Sample Console Output

```
FILE MERGER — Threads + File Handling Demo

Launching both threads simultaneously...

[FileReader-Thread-1] Started
[FileReader-Thread-2] Started

LOCK ACQUIRED

Writing source1.txt

LOCK RELEASED

LOCK ACQUIRED

Writing source2.txt

LOCK RELEASED

MERGE COMPLETE
```

---

# 📂 Output

The merged contents are written to:

```
resources/destination.txt
```

Each merged section is clearly separated with a header indicating which thread processed it.

---

# 🎯 Learning Objectives

This project demonstrates practical implementation of:

- Java Multithreading
- Synchronization
- Shared Resource Management
- File Handling
- Thread Communication
- Object-Oriented Design

---

# 🚀 Future Enhancements

- Merge multiple files dynamically
- GUI using Java Swing
- JavaFX Interface
- Drag & Drop Support
- Folder Merge
- PDF Merge
- Word Document Merge
- Progress Bar
- Logging Framework (Log4j / SLF4J)
- Unit Testing using JUnit

---

# 📸 Screenshots

Add screenshots of:

- Console Output
- Source Files
- Destination File
- Thread Execution Logs

---

# 👨‍💻 Author

**Aryan**

Java Developer | Spring Boot Developer | AI Enthusiast

GitHub: https://github.com/Curiousaryan

---

# ⭐ If you found this project helpful

Give this repository a **Star ⭐** and feel free to fork it.
