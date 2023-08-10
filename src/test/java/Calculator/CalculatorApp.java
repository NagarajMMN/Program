package Calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp {
    public static void viewHistory(List<String> history) {
        System.out.println("Calculation History:");
        for (String entry : history) {
            System.out.println(entry);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> history = CalculationHistory.loadHistory();

        int count = 0;
        boolean continueInput = true;

        List<Double> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        System.out.println("To see final result press = operator");
        System.out.println("when you go with scientific calculation" +'\n'+ "square root the 2nd value should be 0"+'\n'+"square root has operator ~");
        System.out.println("To view history, enter 'history'");
        String command = scanner.next();

        if (command.equalsIgnoreCase("history")) {
            viewHistory(history);
        } else {
            System.out.println("Enter value 1: ");
            double result = scanner.nextDouble();
            numbers.add(result);
            double result1;
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
                result1 = calculator.calculate(result, value);
                System.out.println("Result: " + result1);
                String historyEntry = result + " " + operator + " " + value + " = " + result1;
                history.add(historyEntry);
                CalculationHistory.saveHistory(history);
                result = result1;
            }
            System.out.println("Final Result: " + result);
        }
    }
}
