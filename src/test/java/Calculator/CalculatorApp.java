package Calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        boolean continueInput = true;

        List<Double> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        System.out.print("Enter value 1: ");
        double result = scanner.nextDouble();
        numbers.add(result);

        for (int i = 1; i > count; i++) {
            System.out.print("Enter operator: ");
            String operator = scanner.next();

            if (operator.equalsIgnoreCase("=")) {
                continueInput = false;
                break;
            }
            operators.add(operator);

            System.out.print("Enter value " + (i + 1) + ": ");
            double value = scanner.nextDouble();

            Calculator calculator = CalculatorFactory.createCalculator(operator);
            result = calculator.calculate(result, value);
            System.out.println("Result: " + result);

            numbers.add(value);
        }
        System.out.println("Final Result: " + result);

    }

}
