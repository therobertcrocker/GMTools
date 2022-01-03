package tools.processing;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    private Scanner reader;
    private ArrayList<String> output;

    public ReadFile(String filepath) {
        output = new ArrayList<>();
        try {
            File input = new File(filepath);
            reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                output.add(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }
        
    }

    public ArrayList<String> get() {
        return output;
    }
}