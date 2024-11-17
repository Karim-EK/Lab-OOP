package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File currentFile;
    private File directory;
    private static String PATH = System.getProperty("user.home")
            + File.separator 
            + ".JavaExercises"
            + File.separator;

    public Controller() {
        this.directory = new File(PATH);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        this.currentFile = new File(PATH + "output.txt");
        if (!this.currentFile.exists()) {
            try {
                this.currentFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFile(File file) {
        this.currentFile = file;
    }

    public File getFile() {
        return this.currentFile;
    }

    public String getFilePath() {
        return currentFile.getPath();
    }

    public void saveString(String text) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(this.currentFile));) {
            fileWriter.write(text);        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
