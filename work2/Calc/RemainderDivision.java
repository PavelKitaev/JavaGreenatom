package work2.Calc;

public class RemainderDivision extends Operation {
    public RemainderDivision(double operand1, double operand2) {
        super(operand1, operand2);
    }

    @Override
    double calculate() {
        return getOperand1() % getOperand2();
    }
}
