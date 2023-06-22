package Calculator;

public class Sine implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        if (num2 != 0) {
            throw new IllegalArgumentException("Sine operation only takes one input.");
        }
        return Math.sin(num1);
    }
}
