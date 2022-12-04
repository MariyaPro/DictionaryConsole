package ru.mariya.dictionaryapp.dictionarys;

import ru.mariya.dictionaryapp.ConsoleHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class DictionaryFile {
    private Path dictionarySource;
    private Map<String, String> map = new TreeMap<>();


    public DictionaryFile(Path dictionarySource) {
        this.dictionarySource = dictionarySource;
    }

    public void loadFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(dictionarySource.toFile()));
            do {
                String line = br.readLine();
                String[] words = line.split(" ", 2);
                putWord(words[0], words[1]);
            } while (br.ready());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Map<String, String> getMap() {
        return map;
    }

    public void putWord(String word, String translation) {
        if (isValidWord(word)) map.put(word, translation);
    }

    public boolean removeWord(String word) {
        boolean find = map.containsKey(word);
        if (find) map.remove(word);
        return find;
    }

    public void readDictionary() {
        for (Map.Entry entry : map.entrySet()) {
            ConsoleHelper.writeMessage(entry.toString());
        }
    }

    public String getTranslation(String word) {
        return map.get(word);
    }

    public boolean isValidWord(String word) {
        return false;
    }
}
