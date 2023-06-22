package Calculator;

public class Cosine implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        if (num2 != 0) {
            throw new IllegalArgumentException("Cosine operation only takes one input.");
        }
        return Math.cos(num1);
    }
}
