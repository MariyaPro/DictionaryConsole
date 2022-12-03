package ru.mariya.dictionaryapp.dictionarys;

public interface DictionaryAction {
    void putWord(String word, String translation);

    void removeWord(String word);

    void readDictionary();

    void getTranslation(String word);
}
