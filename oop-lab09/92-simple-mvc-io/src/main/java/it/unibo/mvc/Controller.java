package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File currentFile;
    private final File directory;
    private static final String PATH = System.getProperty("user.home")
            + File.separator 
            + ".JavaExercises"
            + File.separator;

    /**
     * Checks if directory and file exist and eventually crates them.
     */
    public Controller() {
        this.directory = new File(PATH);
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IllegalStateException();
        }
        this.currentFile = new File(PATH + "output.txt");
        if (!this.currentFile.exists()) {
            try {
                if (!this.currentFile.createNewFile()) {
                    throw new IllegalStateException();
                }
            } catch (final IOException e) {
                e.printStackTrace(); // NOPMD suppressed as it is a false positive
            }
        }
    }
    /**
     * Set wich file should be used for saving the string.
     * @param file where to store the string.
     */
    public void setFile(final File file) {
        this.currentFile = file;
    }
    /**
     * Getter for the choosed file.
     * @return the file choosed for saving the string.
     */
    public File getFile() {
        return this.currentFile;
    }
    /**
     * Getter for the file's path.
     * @return the file's path.
     */
    public String getFilePath() {
        return currentFile.getPath();
    }
    /**
     * Save a string on a file choosed with {@link #setFile}.
     * @param text the string to save
     */
    public void saveString(final String text) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(this.currentFile, StandardCharsets.UTF_8));) {
            fileWriter.write(text);
        } catch (final IOException e) {
            e.printStackTrace(); // NOPMD suppressed as it is a false positive
        }
    }
}
