package work2.Calc;

public class Degree extends Operation {
    public Degree(double operand1, double operand2) {
        super(operand1, operand2);
    }

    @Override
    double calculate() {
        return (int)Math.pow(getOperand1(), getOperand2());
    }
}
