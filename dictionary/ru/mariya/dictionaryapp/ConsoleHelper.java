package ru.mariya.dictionaryapp;

import ru.mariya.dictionaryapp.command.*;

import java.io.*;
import java.util.Scanner;

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

    public static Command getCommand() throws ExitException {
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        switch (command){
            case (1): return new ReadCommand();
            case (2): return new PutCommand();
            case (3): return new RemoveCommand();
            case (4): return new GetCommand();
            case (5): return new ExitCommand();
        }

        return new ExitCommand();
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
