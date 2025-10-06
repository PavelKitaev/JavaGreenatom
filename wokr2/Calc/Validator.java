package wokr2.Calc;

public class Validator {

    private String operand1 = "";
    private String operand2 = "";
    private String operation = "";

    public Validator(String operand1, String operand2, String operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
    }

    private boolean validateOperand(String operand) {
        boolean res = true;
        int dotCount = 0; // Счетчик точек

        // Проверяем операнды
        if (operand == null || operand.isEmpty())
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

    public Boolean isValid() {
        // Проверяем operand1 на валидность
        boolean res = validateOperand(operand1);

        // Проверяем operand2 на валидность
        res = validateOperand(operand2);

        if (operation == null || operation.isEmpty())
            res = false;

        return  res;
    }
}
