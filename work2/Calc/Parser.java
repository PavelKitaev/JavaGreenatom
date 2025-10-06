package work2.Calc;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Parser {
    private String operand1;
    private String operand2;
    private String operation = "";
    private Boolean parsed = true;
    private final String expression;

    public Parser(String expression) {
        // Принимаем выражение и удаляем пробелы
        this.expression = expression.replaceAll("\\s+", "");

        // Парсим полученное выражение
        parse();
    }

    private void parse() {
        String tempExpression = expression;
        String tempParse;

        // Валидное выражение не может содержать меньше 3 символов
        if (expression.length() > 3) {
            // Выделяем первый операнд с использованием регулярного выражения
            Matcher matcher = Pattern.compile("^-?\\d+(?:\\.\\d+)?").matcher(expression);
            if (matcher.find()) {
                // Фиксируем первый операнд
                operand1 = matcher.group();

                // Убираем первый операнд из выражения
                tempExpression = tempExpression.substring(matcher.group().length());
            } else {
                parsed = false;
                return;
            }

            // Проверяем, что первый операнд сущесвует и остаток выражения не пустой
            if (!operand1.isEmpty() && !tempExpression.isEmpty()) {
                //Выделяем тип операции
                if (tempExpression.charAt(0) == '+' ||
                        tempExpression.charAt(0) == '-' ||
                        tempExpression.charAt(0) == '*' ||
                        tempExpression.charAt(0) == '^' ||
                        tempExpression.charAt(0) == '%' ) {
                    operation = Character.toString(tempExpression.charAt(0));
                } else if (tempExpression.charAt(0) == '/') {
                    if (tempExpression.charAt(1) == '/') {
                        operation = "//";
                    } else {
                        operation = "/";
                    }
                } else {
                    parsed = false;
                    return;
                }

                if (!operation.isEmpty()) {
                    // Убираем тип операции из выражения
                    tempExpression = tempExpression.substring(operation.length());

                    // Записываем второй операнд
                    operand2 = tempExpression;
                } else {
                    parsed = false;
                }
            } else {
                parsed = false;
            }
        }
    }

    public Boolean isParse() {
        return parsed;
    }

    public String getOperand1() {
        return operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public String getOperation() {
        return operation;
    }
}
