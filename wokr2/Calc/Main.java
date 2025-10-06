package wokr2.Calc;

import java.util.Scanner;

public class Main {
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
        System.out.println("Допустимый формат выражения: 10 + 10");

        while (true) {
            // Запрашиваем и считываем выражение
            System.out.print("Введите выражение: ");
            String expression = scanner.nextLine().trim();

            // Если ввели exit - выходим из цикла
            if (expression.equalsIgnoreCase("exit")) {
                break;
            }

            Parser parser = new Parser(expression);

            if (parser.isParse()) {
                Validator validate = new Validator(parser.getOperand1(), parser.getOperand2(), parser.getOperation());
                if (validate.isValid()) {
                    Calc calc = new Calc(Double.parseDouble(parser.getOperand1()),
                            Double.parseDouble(parser.getOperand2()),
                            parser.getOperation());

                    System.out.println(calc.performOperation());
                } else {
                    System.out.println("Невалидное выражение");
                }
            } else {
                System.out.println("Невалидное выражение");
            }
        }
    }
}
