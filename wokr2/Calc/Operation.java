package wokr2.Calc;

abstract class Operation {
    private final double operand1;
    private final double operand2;

    protected Operation(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    abstract double calculate();

    double getOperand1() {
        return  operand1;
    }

    double getOperand2() {
        return operand2;
    }
}