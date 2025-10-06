package work2.Calc;

public class IntegerDivision extends Operation {
    public IntegerDivision(double operand1, double operand2) {
        super(operand1, operand2);
    }

    @Override
    double calculate() {
        return (int)(getOperand1() / getOperand2());
    }
}