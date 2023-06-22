package Calculator;

public class Division implements Calculator{
    @Override
    public double calculate(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return num1/num2;
    }
}
