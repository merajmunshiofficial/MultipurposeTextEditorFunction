package RadFromHtml;

import java.io.*;

public class RemoveControlCharacters {
    public static void main(String[] args) {
        String inputFilePath = "E:\\@TestFile#\\advancesearchline.txt";
        String outputFilePath = "E:\\@TestFile#\\output.txt";

        removeControlCharacters(inputFilePath, outputFilePath);
    }

    public static void removeControlCharacters(String inputFilePath, String outputFilePath) {
        try {
            // Open the input file for reading
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));

            // Create a StringBuilder to store the modified content
            StringBuilder modifiedContent = new StringBuilder();

            // Read the file line by line
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove control characters and replace with a space
                String modifiedLine = line.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", " ");
                modifiedContent.append(modifiedLine).append(System.lineSeparator());
            }

            // Close the reader
            reader.close();

            // Open the output file for writing
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

            // Write the modified content to the output file
            writer.write(modifiedContent.toString());

            // Close the writer
            writer.close();

            System.out.println("Control characters removed and file written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

