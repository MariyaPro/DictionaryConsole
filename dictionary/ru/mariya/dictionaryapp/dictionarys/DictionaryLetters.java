package ru.mariya.dictionaryapp.dictionarys;

import java.nio.file.Path;

public class DictionaryLetters extends DictionaryFile implements DictionaryAction {
    public DictionaryLetters(Path dictionarySource) {
        super(dictionarySource);
    }

    public boolean isValidWord(String word) {
        return false;
    }

    @Override
    public void putWord(String word, String translation) {

    }

    @Override
    public void removeWord(String word) {

    }

    @Override
    public void readDictionary() {

    }

    @Override
    public void getTranslation(String word) {

    }
}
