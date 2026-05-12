package com.filemerger.config;

import java.io.File;

/**
 * AppConfig holds all application-level constants.
 * Centralizes file paths and settings to avoid hardcoding.
 *
 * Paths use File.separator so they work on BOTH Windows (\) and Unix (/).
 */
public class AppConfig {

    // -------------------------------------------------------
    // File Paths  — works on Windows AND Linux/Mac
    // -------------------------------------------------------
    public static final String SOURCE_FILE_1    = "resources" + File.separator + "source1.txt";
    public static final String SOURCE_FILE_2    = "resources" + File.separator + "source2.txt";
    public static final String DESTINATION_FILE = "resources" + File.separator + "destination.txt";

    // -------------------------------------------------------
    // Thread Settings
    // -------------------------------------------------------
    public static final String THREAD_1_NAME = "FileReader-Thread-1";
    public static final String THREAD_2_NAME = "FileReader-Thread-2";

    // -------------------------------------------------------
    // Separator written between two file contents
    // -------------------------------------------------------
    public static final String SECTION_SEPARATOR =
        "\n\n" +
        "============================================================\n" +
        "          CONTENT MERGED BY : %s\n"                           +
        "============================================================\n\n";

    // Private constructor — utility class, no instantiation
    private AppConfig() {}
}
