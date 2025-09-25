package wokr2.Calc;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Parser {
    private double operand1 = 0;
    private double operand2 = 0;
    private String operation = "";
    private Boolean valid = true;
    private final String expression;
    private String[] parseExpression;

    public Parser(String expression) {
        // Принимаем выражение и удаляем пробелы
        this.expression = expression.replaceAll("\\s+", "");
        parseExpression = new String[3];
        Arrays.fill(parseExpression, ""); // Устанавливаем значение по умолчанию

        // Парсим полученное выражение
        parse();

        // Валидируем
        valid = validate();
    }

    private boolean validate() {
        boolean res = true;

        // Проверяем parseExpression[0] на пустоту и потом валидируем
        if (parseExpression[0] != null && validateOperand(parseExpression[0])) {
            operand1 = Double.parseDouble(parseExpression[0]);
        } else {
            res = false;
        }

        // Проверяем parseExpression[2] на пустоту и потом валидируем
        if (parseExpression[2] != null && validateOperand(parseExpression[2])) {
            operand2 = Double.parseDouble(parseExpression[2]);
        } else {
            res = false;
        }

        if (operation.isEmpty())
            res = false;

        return  res;
    }

    private boolean validateOperand(String operand) {
        boolean res = true;
        int dotCount = 0; // Счетчик точек

        // Проверяем операнды
        if (operand.isEmpty())
            return false;

        for (int i = 0; i < operand.length(); ++i) {
            if (i == 0) {
                // Проверяем первый элемент на число или знак минус
                if (!Character.isDigit(operand.charAt(i)) && operand.charAt(i) != '-') {
                    // Если это не так - выходим
                    res = false;
                    break;
                }
            } else {
                // Проверяем остальные элементы на число или точку
                if (!Character.isDigit(operand.charAt(i)) && operand.charAt(i) != '.') {
                    // Если это не так - выходим
                    res = false;
                    break;
                }

                // Считаем точки
                if (operand.charAt(i) == '.') {
                    dotCount++;
                }
            }
        }

        if (dotCount > 1)
            res = false;

        return res;
    }

    private void parse() {
        String tempExpression = expression;

        // Валидное выражение не может содержать меньше 3 символов
        if (expression.length() > 3) {
            // Выделяем первый операнд с использованием регулярного выражения
            Matcher matcher = Pattern.compile("^-?\\d+(?:\\.\\d+)?").matcher(expression);
            if (matcher.find()) {
                // Фиксируем длину первого операнда
                parseExpression[0] = matcher.group();

                // Убираем первый операнд из выражения
                tempExpression = tempExpression.substring(matcher.group().length());
            }

            // Проверяем, что первый операнд сущесвуте
            if (!parseExpression[0].isEmpty() && !tempExpression.isEmpty()) {
                //Выделяем тип операции
                if (tempExpression.charAt(0) == '+' ||
                        tempExpression.charAt(0) == '-' ||
                        tempExpression.charAt(0) == '*' ||
                        tempExpression.charAt(0) == '^' ||
                        tempExpression.charAt(0) == '%' ) {
                    parseExpression[1] = Character.toString(tempExpression.charAt(0));
                } else if (tempExpression.charAt(0) == '/') {
                    if (tempExpression.charAt(1) == '/') {
                        parseExpression[1] = "//";
                    } else {
                        parseExpression[1] = "/";
                    }
                }

                if (!parseExpression[1].isEmpty()) {
                    // Убираем тип операции из выражения
                    tempExpression = tempExpression.substring(parseExpression[1].length());

                    // Записываем тип операции
                    operation = parseExpression[1];

                    // Записываем второй операнд
                    parseExpression[2] = tempExpression;
                }
            }
        }
    }

    public Boolean isValid() {
        return valid;
    }

    public double getOperand1() {
        return operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public String getOperation() {
        return operation;
    }
}
