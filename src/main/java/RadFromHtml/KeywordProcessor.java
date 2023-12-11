package RadFromHtml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KeywordProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path of the input file containing keywords: ");
        String inputFilePath = scanner.nextLine();

        System.out.print("Enter the path for the output file: ");
        String outputFilePath = scanner.nextLine();

        try {
            // Read the keywords from the file
            List<String> keywords = readKeywordsFromFile(inputFilePath);

            // Process the keywords and generate the output
            List<String> outputList = new ArrayList<>();
            for (String keyword : keywords) {
                String output = keyword.toLowerCase()
                        .replaceAll("\\s+", "-")
                        .replaceAll("[^a-z0-9-]", "");
                outputList.add(output);
            }

            // Write the output to a new file
            writeOutputToFile(outputFilePath, outputList);

            System.out.println("Output file created successfully. Path: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readKeywordsFromFile(String filePath) throws IOException {
        List<String> keywords = new ArrayList<>();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            keywords.add(line.trim());
        }

        bufferedReader.close();
        fileReader.close();

        return keywords;
    }

    private static void writeOutputToFile(String filePath, List<String> outputList) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        for (String output : outputList) {
            writer.write(output + System.lineSeparator());
        }
        writer.close();
    }
}
