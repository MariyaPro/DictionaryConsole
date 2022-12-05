package dictionaryapp.command;

import dictionaryapp.ConsoleDictionaryApp;
import dictionaryapp.ConsoleHelper;
import dictionaryapp.dictionaries.DictionaryFile;

import java.util.List;

public class PutCommand implements Command {

    @Override
    public void execute() {
        ConsoleHelper.writeMessage("Введите слово:");
        String putWord = ConsoleHelper.readMessage();
        ConsoleHelper.writeMessage("Введите перевод:");
        String putTranslation = ConsoleHelper.readMessage();

        List<DictionaryFile> list = ConsoleDictionaryApp.getDictionaryList();
        boolean addWord = false;
        for (DictionaryFile dic : list) {
            if (dic.putWord(putWord, putTranslation)) {
                addWord = true;
                break;
            }
        }
        ConsoleHelper.writeMessage(addWord ? "Слово добавлено." : "Слово не удовлетворяет критериям словаря.");
    }
}
