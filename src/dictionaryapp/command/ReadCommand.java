package dictionaryapp.command;

import dictionaryapp.ConsoleDictionaryApp;
import dictionaryapp.dictionaries.DictionaryFile;

import java.util.List;

public class ReadCommand implements Command{

    @Override
    public void execute() {
        List<DictionaryFile> list = ConsoleDictionaryApp.getDictionaryList();
        list.forEach(DictionaryFile::readDictionary);
    }
}
