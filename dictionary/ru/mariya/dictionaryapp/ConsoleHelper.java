package ru.mariya.dictionaryapp;

import ru.mariya.dictionaryapp.command.Command;
import ru.mariya.dictionaryapp.command.ExitCommand;

import java.io.*;

public class ConsoleHelper {
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readMessage() {
        String str = null;
        do {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                str = br.readLine();
            } catch (IOException e) {
                System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        } while (str == null);
        return str;
    }

    public static Command getCommand() throws ExitException{


        return new ExitCommand();
    }
}
