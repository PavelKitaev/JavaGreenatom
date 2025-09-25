package wokr2.Calc;

public class Subtract extends Operation {
    public Subtract(double operand1, double operand2) {
        super(operand1, operand2);
    }

    @Override
    double calculate() {
        return getOperand1() - getOperand2();
    }
}
