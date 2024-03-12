//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Araf\\IdeaProjects\\CountWord\\src\\input.txt";

        try {
            // Read the file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // Map to store word counts
            Map<String, Integer> wordCountMap = new TreeMap<>();

            // Read each line from the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using space as a delimiter
                String[] words = line.split("\\s+");

                // Update word counts in the map
                for (String word : words) {
                    // Remove non-alphabetic characters and convert to lowercase
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    // Increment the count for the word in the map
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }

            // Display word counts in alphabetical order
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Close the reader
            reader.close();

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}