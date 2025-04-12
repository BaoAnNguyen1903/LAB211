package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class DictionaryModel {
    private final HashMap<String, String> dictionary;

    public DictionaryModel() {
        dictionary = new HashMap<>();
    }

    public boolean addWord(String eng, String vi) {
        if (!dictionary.containsKey(eng)) {
            dictionary.put(eng, vi);
            updateDatabase();
            return true;
        }
        return false;
    }

    public boolean removeWord(String eng) {
        if (dictionary.containsKey(eng)) {
            dictionary.remove(eng);
            updateDatabase();
            return true;
        }
        return false;
    }

    public String translate(String eng) {
        return dictionary.getOrDefault(eng, "Not Found");
    }

    private void updateDatabase() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("dictionary.txt"))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
        }
    }

    public void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    dictionary.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
        }
    }
}
