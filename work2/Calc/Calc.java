package work2.Calc;

public class Calc {
    private double operand1;
    private double operand2;
    private String operation;

    public Calc(double operand1, double operand2, String operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double performOperation() {
        Operation op = null;

        switch(operation) {
            case "+":
                op = new Sum(operand1, operand2);
                break;
            case "-":
                op = new Subtract(operand1, operand2);
                break;
            case "*":
                op = new Multiplication(operand1, operand2);
                break;
            case "/":
                op = new Division(operand1, operand2);
                break;
            case "//":
                op = new IntegerDivision(operand1, operand2);
                break;
            case "^":
                op = new Degree(operand1, operand2);
                break;
            case "%":
                op = new RemainderDivision(operand1, operand2);
                break;
        }

        return op.calculate();
    }
}
