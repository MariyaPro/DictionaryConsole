package ru.mariya.dictionaryapp;

import ru.mariya.dictionaryapp.command.Command;
import ru.mariya.dictionaryapp.dictionarys.DictionaryFile;
import ru.mariya.dictionaryapp.dictionarys.DictionaryLetters;
import ru.mariya.dictionaryapp.dictionarys.DictionaryNumbers;

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


        try {
            while (true) {
                ConsoleHelper.writeMenu();
                Command command = ConsoleHelper.getCommand();
                command.execute();
            }
        } catch (ExitException e) {
            ConsoleHelper.writeMessage("End");
        }

    }

    private static void setDictionaryList() {
        dictionaryList = new ArrayList<>();
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("C:\\Users\\Мария\\IdeaProjects\\DictionaryConsole\\dictionary\\ru\\mariya\\dictionaryapp\\pathDictionarysFilesSource"));
            // properties.load(new FileReader(ConsoleDictionaryApp.class.getCanonicalName().replaceAll("\\.","\\")+"\\pathDictionarysFilesSourse"));

        } catch (IOException e) {
            ConsoleHelper.writeMessage("Не найден файл pathDictionarysFilesSource");
        }
        dictionaryList.add(new DictionaryLetters(Paths.get(properties.getProperty("dictionaryLetters"))));
        dictionaryList.add(new DictionaryNumbers(Paths.get(properties.getProperty("dictionaryNumbers"))));
    }

    public static List<DictionaryFile> getDictionaryList() {
        return dictionaryList;
    }

    private static void loadDictionary() {
        for (DictionaryFile dic : dictionaryList) {
            dic.loadFromFile();
            System.out.println(dic.getMap().size());
        }
    }
}
