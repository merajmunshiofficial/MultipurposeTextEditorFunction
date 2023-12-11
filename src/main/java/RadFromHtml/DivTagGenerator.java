package RadFromHtml;

import java.io.*;
import java.util.Scanner;

public class DivTagGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path of the input file: ");
        String inputFilePath = scanner.nextLine();

        System.out.println("Enter the path of the output file: ");
        String outputFilePath = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
             
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write("<div class=\"page\">\n");
                writer.write(line + "\n");
                writer.write("</div>\n");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
