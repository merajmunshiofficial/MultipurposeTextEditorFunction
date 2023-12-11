package RadFromHtml;

import java.io.*;
import java.util.Scanner;

public class MergeTxtFiles {

    public static void main(String[] args) {

        // Set the path of the directory that contains files to merge
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the prefix of file names (e.g., output_): ");
        String fileNamePrefix = sc.next();
        
        System.out.println("Enter the input directory path: ");
        // Consume the newline character left by sc.next() to avoid skipping the next input
        sc.nextLine();
        String inputDir = sc.nextLine();
        
        System.out.println("Enter the output directory path: ");
        String outputDir = sc.nextLine();

        System.out.println("Enter the output file name: ");
        String outputFileName = sc.nextLine();

        // Use File.separator instead of "\\" to ensure compatibility with different operating systems
        String outputFile = outputDir + File.separator + outputFileName + ".txt";

        System.out.println("Enter the total number of files to merge: ");
        int numberOfFiles = sc.nextInt();

        sc.close(); // Close the Scanner object
        
        try {
            // Create a new output file
            File mergedFile = new File(outputFile);
            mergedFile.createNewFile();

            // Open the output file for writing
            FileWriter writer = new FileWriter(mergedFile);

            // Loop over each file and merge them serially
            for (int i = 0; i < numberOfFiles; i++) {
                // Construct the path to the input file
                String inputFilePath = inputDir + File.separator + fileNamePrefix + i + ".txt";

                // Open the input file for reading
                BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));

                // Write the contents of the file to the output file
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line + "\n");
                }

                // Close the input file
                reader.close();
            }

            // Close the output file
            writer.close();

            System.out.println("Merged files successfully.");

        } catch (IOException e) {
            System.err.println("Error merging files: " + e.getMessage());
        }
    }
}
