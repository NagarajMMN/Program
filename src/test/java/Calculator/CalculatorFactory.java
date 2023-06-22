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
            case "~":
                return new SquareRoot();
            case "^":
                return new Exponentiation();
            case "log":
                return new Logarithm();
            case "sin":
                return new Sine();
            case "cos":
                return new Cosine();
            case "tan":
                return new Tangent();
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
