package org.example.managers;

import org.example.common.exceptions.UnknownCommandException;
import org.example.common.responses.StartRequest;

/**
 * Клас для валидации данных
 */
public class Validator {
    /**
     * Валидация числа введенных аргументов
     * @param args аргументы
     * @param countArgs число аргументов, которое должно быть
     */
    public static void validateCountArgs(String[] args, int countArgs) throws UnknownCommandException {
        int count = 0;
        if (!args[0].equals("")) {
            count = args.length;
        }
        if (count != countArgs) {
            throw new UnknownCommandException("Ошибка: аргументов неправильное количество.");
        }
    }
    /**
     * Валидация ID
     * @param arg аргумент
     */
    public static void validateId(String arg) throws UnknownCommandException {
        try {
            int id = Integer.parseInt(arg);
            if (id < 0) throw new UnknownCommandException("Ошибка: введенный id не является положительным числом.");
        } catch (NumberFormatException e) {
            throw new UnknownCommandException("Ошибка: введенный id не является целым положительным числом, либо превышена максимальная величина целого числа.");
        }
    }
    /**
     * Валидация ключа
     * @param arg аргумент
     */
    public static void validateKey(String arg) throws UnknownCommandException {
        try {
            int key = Integer.parseInt(arg);
            if (key < 0) {
                throw new UnknownCommandException("Ошибка: введенный ключ не является положительным числом.");
            }
        } catch (NumberFormatException e) {
            throw new UnknownCommandException("Ошибка: введенный ключ не является целым положительным числом, либо превышена максимальная величина целого числа.");
        }
    }
    /**
     * Валидация элемента Enum-а
     * @param arg аргумент
     * @param en Enum, в котором должен быть аргумент
     */
    public static <T extends Enum<T>> void validateEnum(String arg, Class<T> en) throws UnknownCommandException {
        try {
            T a = Enum.valueOf(en, arg.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new UnknownCommandException(String.format("Ошибка: введенной константы типа %s не существует", en.getSimpleName()));
        }
    }

    public static void validateCommand(String command, StartRequest startRequest) throws UnknownCommandException {
        if (!startRequest.getCommands().containsKey(command)) throw new UnknownCommandException("Ошибка: несуществующая команда");
    }
}
