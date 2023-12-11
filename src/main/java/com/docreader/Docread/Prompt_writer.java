package com.docreader.Docread;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Prompt_writer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the input file path
        System.out.print("Enter the input file path: ");
        String inputFilePath = scanner.nextLine();

        // Prompt the user to enter the output file path
        System.out.print("Enter the output file path: ");
        String outputFilePath = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File(inputFilePath));
             FileWriter writer = new FileWriter(outputFilePath)) {
            while (fileScanner.hasNextLine()) {
                // Read a line from the input file
                String line = fileScanner.nextLine();

                // Split the line into an array of strings using whitespace as the delimiter
                String[] stringArray = line.split("\\s+");

                // Write the string array to the output file
                for (String s : stringArray) {
                    writer.write("Teach me \"" + s + "\" in Spring\n");
                }

            }
            System.out.println("File has been Succesfully Written !! Enjoy !!");
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing the file.");
            e.printStackTrace();
        }
    }
}
