package Calculator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CalculationHistory {
    private static CalculationHistory instance = null;
    private static final String HISTORY_FILE = "C:\\Users\\nagar\\Pictures\\History File.txt";

    public static CalculationHistory getInstance() {
        if (instance == null) {
            instance = new CalculationHistory();
        }
        return instance;
    }

    public static void saveHistory(List<String> history) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE))) {
            for (String entry : history) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<String> loadHistory() {
        List<String> history = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(HISTORY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                history.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return history;
    }
}
