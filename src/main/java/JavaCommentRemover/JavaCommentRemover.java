package JavaCommentRemover;

import java.io.*;

import java.io.*;
import java.util.Scanner;

public class JavaCommentRemover {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user for input file name
        System.out.print("Enter input file name: ");
        String inputFile = scanner.nextLine();

        // Prompt user for output file name
        System.out.print("Enter output file name: ");
        String outputFile = scanner.nextLine();

        scanner.close();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            String line;
            boolean commentFlag = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // Check for comment start and end
                if (line.startsWith("/*")) {
                    commentFlag = true;
                }

                if (!commentFlag && !line.startsWith("//")) {
                    writer.write(line + System.getProperty("line.separator"));
                }

                if (line.endsWith("*/")) {
                    commentFlag = false;
                }
            }

            reader.close();
            writer.close();

            System.out.println("Comments removed successfully!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
