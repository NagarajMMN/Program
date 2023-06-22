package Calculator;

public class Logarithm implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        if (num1 <= 0 || num2 <= 0) {
            throw new IllegalArgumentException("Both inputs must be greater than 0 for logarithm calculation.");
        }
        return Math.log(num1) / Math.log(num2);
    }
}
