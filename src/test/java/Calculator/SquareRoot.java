package Calculator;

public class SquareRoot implements Calculator{
    @Override
    public double calculate(double num1, double num2) {
        if (num2 != 0) {
            throw new IllegalArgumentException("Square root operation only takes one input.");
        }
        if (num1 < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number.");
        }
        return Math.sqrt(num1);
    }
}
