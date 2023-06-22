package Calculator;

public class Tangent implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        if (num2 != 0) {
            throw new IllegalArgumentException("Tangent operation only takes one input.");
        }
        return Math.tan(num1);
    }
}
