package ru.mariya.dictionaryapp.dictionaries;

import java.nio.file.Path;

public class DictionaryLetters extends DictionaryFile {
    public DictionaryLetters(Path dictionarySource) {
        super(dictionarySource);
    }

    public boolean isValidWord(String word) {
        int length = 4;
        if (word.length() != length) return false;
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            if (c < 65 || c > 122 || c > 90 && c < 97) return false;
        }
        return true;
    }
}
