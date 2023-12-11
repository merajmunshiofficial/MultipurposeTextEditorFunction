package RadFromHtml;

import java.io.*;
import java.util.Scanner;

import org.apache.poi.xwpf.usermodel.*;

public class TxtToDocxConverter {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the Input//Output Directory : ");
    	String Path= sc.nextLine();
        String inputFilePath = Path+ File.separator +  "Final_Merge_SpringCore.txt";  // Change this to the path of your input text file
        String outputFilePath = Path + File.separator +  "Final_Merge_SpringCore.docx";  // Change this to the desired path of your output Word document

        try {
            // Open the input text file for reading
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));

            // Create a new Word document and add a paragraph to it
            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();

            // Read each line from the text file and add it to the paragraph
            String line;
            while ((line = reader.readLine()) != null) {
                paragraph.createRun().setText(line);
                paragraph.createRun().addBreak();
            }

            // Close the input file
            reader.close();

            // Save the Word document to disk
            FileOutputStream outputStream = new FileOutputStream(outputFilePath);
            document.write(outputStream);
            outputStream.close();

            System.out.println("Conversion complete.");

        } catch (IOException e) {
            System.err.println("Error converting file: " + e.getMessage());
        }
    }
}

