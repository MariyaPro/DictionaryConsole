package dictionaryapp.dictionaries;

import dictionaryapp.ConsoleHelper;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class DictionaryFile {
    private final Path dictionarySource;
    private final Map<String, String> map = new TreeMap<>();
    private boolean isModified = false;

    public DictionaryFile(Path dictionarySource) {
        this.dictionarySource = dictionarySource;
    }

    public void loadFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(dictionarySource.toFile()));
            while (br.ready()) {
                String line = br.readLine();
                String[] words = line.split("=");
                map.put(words[0], words[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isModified() {
        return isModified;
    }

    public boolean putWord(String word, String translation) {
        boolean isValid = false;
        if (isValidWord(word)) {
            map.put(word, translation);
            isValid = true;
            isModified = true;
        }
        return isValid;
    }

    public boolean removeWord(String word) {
        boolean find = map.containsKey(word);
        if (find) {
            map.remove(word);
            isModified = true;
        }
        return find;
    }

    public void readDictionary() {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            ConsoleHelper.writeMessage(entry.getKey() + " = " + entry.getValue());
        }
    }

    public String getTranslation(String word) {
        return map.getOrDefault(word, null);
    }

    boolean isValidWord(@NotNull String word) {
        return false;
    }

    public void saveToFile() {
        try (FileWriter fileWriter = new FileWriter(dictionarySource.toFile())) {
            for (String word : map.keySet()) {
                fileWriter.write(word + "=" + map.get(word) + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
