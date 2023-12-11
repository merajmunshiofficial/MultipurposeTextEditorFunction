package RadFromHtml;

import java.io.*;

public class RemoveSTXFromFile {
    public static void main(String[] args) {
        String inputFilePath = "E:\\@TestFile#\\advancesearchline.txt";
        String outputFilePath = "E:\\@TestFile#\\output.txt";

        removeSTXFromFile(inputFilePath, outputFilePath);
    }

    public static void removeSTXFromFile(String inputFilePath, String outputFilePath) {
        try {
            // Open the input file for reading
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));

            // Create a StringBuilder to store the modified content
            StringBuilder modifiedContent = new StringBuilder();

            // Read the file line by line
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove STX characters from the line and append it to the modified content
                String modifiedLine = line.replaceAll("\u0002", "");
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

            System.out.println("STX characters removed and file written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

