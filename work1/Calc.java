package work1;

import java.util.Scanner;

public class Calc {

    // Разбиваем полученное выражение на 3 части
    public static String[] split(String expression) {
        return expression.split("\\s+");
    }

    public static double sum(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        if (b == 0)
            return 0;

        return a / b;
    }

    public static int integerDivision(double a, double b) {
        if (b == 0)
            return 0;

        return (int)(a / b);
    }

    public static int degree(double a, double b) {
        return (int)Math.pow(a, b);
    }

    public static double remainderDivision(double a, double b) {
        return a % b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вывод функционала
        System.out.println("Поддерживаемые операции:");
        System.out.println("Сложение (+)");
        System.out.println("Вычитание (-)");
        System.out.println("Умножение (*)");
        System.out.println("Деление (/)");
        System.out.println("Целочисленное деление (//)");
        System.out.println("Возведение в степень (^)");
        System.out.println("Остаток от деления (%)");

        // Вечный цикл, пока не будет получен сигнал выхода
        while (true) {
            // Запрашиваем и считываем выражение
            System.out.print("Введите выражение: ");
            String expression = scanner.nextLine().trim();

            // Если ввели exit - выходим из цикла
            if (expression.equalsIgnoreCase("exit")) {
                break;
            }

            // Разделяем строку на части
            String[] parts = split(expression);

            // Если получено не 3 части - сообщаем об ошибке
            if (parts.length != 3) {
                System.out.println("Неверное выражение");
            } else {
                double a = Double.parseDouble(parts[0]);
                String operator = parts[1];
                double b = Double.parseDouble(parts[2]);
                // Вызываем функции для каждой из операций
                switch (operator) {
                    case "+":
                        System.out.println("Результат: " + sum(a, b));
                        break;
                    case "-":
                        System.out.println("Результат: " + subtract(a, b));
                        break;
                    case "*":
                        System.out.println("Результат: " + multiplication(a, b));
                        break;
                    case "/":
                        if (b == 0)
                            System.out.println("Ошибка - деление на ноль");
                        else
                            System.out.println("Результат: " + division(a, b));
                        break;
                    case "//":
                        System.out.println("Результат: " + integerDivision(a, b));
                        break;
                    case "^":
                        System.out.println("Результат: " + degree(a, b));
                        break;
                    case "%":
                        System.out.println("Результат: " + remainderDivision(a, b));
                        break;
                }
            }
        }
    }
}
