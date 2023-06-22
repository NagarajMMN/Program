package Calculator;

public class CalculatorFactory {
    public static Calculator createCalculator(String operator) {
        switch (operator) {
            case "+":
                return new Addition();
            case "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            case "/":
                return new Division();
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
