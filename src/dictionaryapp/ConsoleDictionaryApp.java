package dictionaryapp;

import dictionaryapp.command.Command;
import dictionaryapp.dictionaries.DictionaryLetters;
import dictionaryapp.dictionaries.DictionaryNumbers;
import dictionaryapp.dictionaries.DictionaryFile;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConsoleDictionaryApp {
    private static List<DictionaryFile> dictionaryList;

    public static void main(String[] args) {
        setDictionaryList();
        loadDictionary();

        Command command;
        do {
            ConsoleHelper.writeMenu();
            do {
                command = ConsoleHelper.getCommand();
                if (command == null) ConsoleHelper.writeMessage("Некорректный ввод. Попробуйте еще раз.");
            } while (command == null);
            command.execute();
            ConsoleHelper.writeMessage("");
        } while (!command.getClass().getSimpleName().equalsIgnoreCase("ExitCommand"));

    }

    private static void setDictionaryList() {
        dictionaryList = new ArrayList<>();
        Properties properties = new Properties();
        try {
          // properties.load(new FileReader("C:\\Users\\Мария\\IdeaProjects\\DictionaryConsole\\dictionary\\ru\\mariya\\dictionaryapp\\pathDictionariesFilesSource"));
             properties.load(new FileReader("resources/pathDictionariesFilesSource"));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Не найден файл pathDictionariesFilesSource");
        }
        dictionaryList.add(new DictionaryLetters(Paths.get(properties.getProperty("dictionaryLetters"))));
        dictionaryList.add(new DictionaryNumbers(Paths.get(properties.getProperty("dictionaryNumbers"))));
    }

    public static List<DictionaryFile> getDictionaryList() {
        return dictionaryList;
    }

    private static void loadDictionary() {
        for (DictionaryFile dic : dictionaryList)
            dic.loadFromFile();
    }
}
