package Calculator;

public class Addition implements Calculator {

    @Override
    public double calculate(double num1, double num2) {
        return num1+num2;
    }
}
