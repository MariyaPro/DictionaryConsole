package ru.mariya.dictionaryapp.command;

import ru.mariya.dictionaryapp.ConsoleDictionaryApp;
import ru.mariya.dictionaryapp.dictionarys.DictionaryAction;

import java.util.List;

public class ReadCommand implements Command{

    @Override
    public void execute() {
        List<DictionaryAction> list = ConsoleDictionaryApp.getDictionaryList();

    }
}
