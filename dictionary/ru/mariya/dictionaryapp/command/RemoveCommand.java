package ru.mariya.dictionaryapp.command;

import ru.mariya.dictionaryapp.ConsoleDictionaryApp;
import ru.mariya.dictionaryapp.ConsoleHelper;
import ru.mariya.dictionaryapp.dictionarys.DictionaryFile;

import java.util.List;

public class RemoveCommand implements Command {

    @Override
    public void execute() {
        ConsoleHelper.writeMessage("Введите слово:");
        String removeWord = ConsoleHelper.readMessage();
        List<DictionaryFile> list = ConsoleDictionaryApp.getDictionaryList();
        boolean find = false;
        for (DictionaryFile dic : list) {
            if (dic.removeWord(removeWord)) {
                find = true;
                break;
            }
        }
        if (find) ConsoleHelper.writeMessage("Слово удалено.");
        else ConsoleHelper.writeMessage("Слово не найдено в словаре.");
    }
}
