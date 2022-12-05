package dictionaryapp;

import dictionaryapp.command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readMessage() {
        String str = null;
        do {
            try {
                str = br.readLine();
            } catch (IOException e) {
                System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        } while (str == null);
        return str;
    }

    public static Command getCommand() {
        String commandStr = readMessage();
        return switch (commandStr) {
            case ("1") -> new ReadCommand();
            case ("2") -> new PutCommand();
            case ("3") -> new RemoveCommand();
            case ("4") -> new GetCommand();
            case ("5") -> new ExitCommand();
            default -> null;
        };

    }

    public static void writeMenu() {
        System.out.println("1 - Вывести на экран содержимое словаря.");
        System.out.println("2 - Добавить слово в словарь.");
        System.out.println("3 - Удалить слово из словаря.");
        System.out.println("4 - Перевести слово.");
        System.out.println("5 - Завершение работы.");
        System.out.println("Введите номер команды:");
    }
}
