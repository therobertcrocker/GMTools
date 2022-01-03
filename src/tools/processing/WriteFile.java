package tools.processing;

import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors
import java.util.ArrayList;
import java.io.FileWriter;

public class WriteFile {
    private String f;
    private String body;

    public WriteFile(String file, String body) {
        this.f = file;
        this.body = body;
    }

    public void make() {
        try {
            File file = new File(f);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                if (file.canWrite()) {
                    write(f, body);
                }
            } else {
                System.out.println("File already exists.");
                if (file.canWrite()) {
                    write(f, body);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void write(String f, String body) {
        try {
            FileWriter writer = new FileWriter(f);
            writer.write(body);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
