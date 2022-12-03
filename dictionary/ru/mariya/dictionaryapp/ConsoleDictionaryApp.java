package ru.mariya.dictionaryapp;

import ru.mariya.dictionaryapp.command.Command;
import ru.mariya.dictionaryapp.dictionarys.DictionaryAction;
import ru.mariya.dictionaryapp.dictionarys.DictionaryLetters;
import ru.mariya.dictionaryapp.dictionarys.DictionaryNumbers;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConsoleDictionaryApp {
    private static List<DictionaryAction> dictionaryList;

    public static void main(String[] args) {
        setDictionaryList();
        try {
            while (true) {
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

        dictionaryList.add(new DictionaryLetters(Paths.get(properties.getProperty("dictionaryLetters"))));
        dictionaryList.add(new DictionaryNumbers(Paths.get(properties.getProperty("dictionaryNumbers"))));
    }

    public static List<DictionaryAction> getDictionaryList() {
        return dictionaryList;
    }
}
