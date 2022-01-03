package tools.generator;

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

import tools.processing.*;

public class Generator {
    private HashMap<String, ArrayList<String>> tables;
    private Random random;

    public Generator() {
        tables = new HashMap<>();
        random = new Random(System.currentTimeMillis());
    }

    public void add(Table table) {
        tables.put(table.getName(), table.getItems());
    }

    public String roll(String key) {
        ArrayList<String> table = tables.get(key);
        return table.get(random.nextInt(table.size() - 1));
    }
}