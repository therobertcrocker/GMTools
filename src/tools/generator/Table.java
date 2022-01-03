package tools.generator;

import java.util.ArrayList;

import tools.processing.ReadFile;

public class Table {
    private ReadFile reader;
    private String name;
    private ArrayList<String> items;

    public Table(String name, String filepath) {
        reader = new ReadFile(filepath);
        this.name = name;
        items = reader.get();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getItems() {
        return items;
    }
}
