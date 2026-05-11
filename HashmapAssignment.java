import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class SalesAnalyzer {

    public static void main(String[] args) {

        String inputFile = "productfile.txt";
        HashMap<String, Double> salesMap = new HashMap<>();

        try {
            Files.lines(Paths.get(inputFile))
                .skip(1)
                .filter(line -> !line.trim().isEmpty())
                .forEach(line -> {

                    String[] dataSegments = line.trim().split("\\s+");

                    if (dataSegments.length < 10) return;

                    String productName = dataSegments[7] + " " + dataSegments[8];

                    try {
                        double totalValue = Double.parseDouble(dataSegments[9]);
                        salesMap.merge(productName, totalValue, Double::sum);

                    } catch (NumberFormatException nfe) {
                        System.out.println("Hmm, couldn't read the amount on this line — skipping it: " + line);
                    }
                });

        } catch (java.nio.file.NoSuchFileException nsfe) {
            System.out.println("Couldn't find the file '" + inputFile + "' — double-check the name and location.");
            return;
        } catch (IOException ioe) {
            System.out.println("Something went wrong while reading the file: " + ioe.getMessage());
            return;
        }

        System.out.println("===================================");
        System.out.printf("%-15s %10s%n", "Product", "Total Amount");
        System.out.println("===================================");

        for (Map.Entry<String, Double> entry : salesMap.entrySet()) {
            System.out.printf("%-15s %10.2f%n", entry.getKey(), entry.getValue());
        }

        System.out.println("===================================");
    }
}
