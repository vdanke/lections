package org.step.third;

import java.io.File;
import java.io.FileNotFoundException;

public class FileCheckerUtil {

    public static final String MATERIAL_FILE = "material.txt";
    public static final String STREAM_EXAMPLE_FIRST_FILE = "stream_first.txt";
    public static final String STREAM_EXAMPLE_SECOND_FILE = "stream_second.txt";

    public static void fileChecker() throws FileNotFoundException {
        File firstFile = new File(MATERIAL_FILE);
        File secondFile = new File(STREAM_EXAMPLE_FIRST_FILE);
        File thirdFile = new File(STREAM_EXAMPLE_SECOND_FILE);

        if (!firstFile.exists() || !secondFile.exists() || !thirdFile.exists()) {
            throw new FileNotFoundException("Those file not found");
        }
    }
}
