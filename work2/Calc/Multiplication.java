package work2.Calc;

public class Multiplication extends Operation {
    public Multiplication(double operand1, double operand2) {
        super(operand1, operand2);
    }

    @Override
    double calculate() {
        return getOperand1() * getOperand2();
    }
}
