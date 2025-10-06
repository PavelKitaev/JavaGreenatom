package work2.Calc;

public class Division extends Operation {
    public Division(double operand1, double operand2) {
        super(operand1, operand2);
    }

    @Override
    double calculate() {
        return getOperand1() / getOperand2();
    }
}