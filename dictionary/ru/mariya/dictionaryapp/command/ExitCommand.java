package ru.mariya.dictionaryapp.command;

import ru.mariya.dictionaryapp.ConsoleDictionaryApp;
import ru.mariya.dictionaryapp.ConsoleHelper;
import ru.mariya.dictionaryapp.dictionaries.DictionaryFile;

import java.util.List;

public class ExitCommand  implements Command {

    @Override
    public void execute() {
        ConsoleHelper.writeMessage("Сохранить изменения?");
        ConsoleHelper.writeMessage("Y - да, сохранить.");
        ConsoleHelper.writeMessage("N - нет, не сохранять.");
        String ans = ConsoleHelper.readMessage();
        if (ans.equalsIgnoreCase("Y")) {
            List<DictionaryFile> list = ConsoleDictionaryApp.getDictionaryList();
            for (DictionaryFile dic : list)
                if (dic.isModified()) dic.saveToFile();
            ConsoleHelper.writeMessage("Изменения сохранены.");
        }
    }
}
