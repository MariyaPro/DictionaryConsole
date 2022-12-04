package ru.mariya.dictionaryapp.command;

import ru.mariya.dictionaryapp.ConsoleDictionaryApp;
import ru.mariya.dictionaryapp.dictionarys.DictionaryFile;

import java.util.List;

public class ReadCommand implements Command{

    @Override
    public void execute() {
        List<DictionaryFile> list = ConsoleDictionaryApp.getDictionaryList();
        list.forEach(DictionaryFile::readDictionary);
    }
}
