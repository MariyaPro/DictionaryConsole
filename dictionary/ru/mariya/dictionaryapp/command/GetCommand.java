package ru.mariya.dictionaryapp.command;

import ru.mariya.dictionaryapp.ConsoleDictionaryApp;
import ru.mariya.dictionaryapp.ConsoleHelper;
import ru.mariya.dictionaryapp.dictionaries.DictionaryFile;

import java.util.List;

public class GetCommand implements Command{

    @Override
    public void execute() {
        ConsoleHelper.writeMessage("Введите слово:");
        String getWord = ConsoleHelper.readMessage();

        List<DictionaryFile> list = ConsoleDictionaryApp.getDictionaryList();
        for (DictionaryFile dic :list){
            String translation = dic.getTranslation(getWord);
        }
    }
}
