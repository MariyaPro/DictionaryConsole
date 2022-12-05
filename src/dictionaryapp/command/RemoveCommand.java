package dictionaryapp.command;

import dictionaryapp.ConsoleDictionaryApp;
import dictionaryapp.ConsoleHelper;
import dictionaryapp.dictionaries.DictionaryFile;

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
        ConsoleHelper.writeMessage(find ? "Слово удалено." : "Слово не найдено в словаре.");
    }
}
