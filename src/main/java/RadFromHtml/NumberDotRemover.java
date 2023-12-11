package RadFromHtml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NumberDotRemover {
    public static void main(String[] args) {
        String inputFile = "D:\\#@Doc\\web_file\\Web_on_Reactive_Stack.txt";
        String outputFile = "D:\\#@Doc\\Webon_Reactive_Stack_Final.txt";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            FileWriter writer = new FileWriter(outputFile);
            String line;
            while ((line = reader.readLine()) != null) {
                String cleanedLine = line.replaceAll("[0-9.]+", "");
                writer.write(cleanedLine + "\n");
            }
            reader.close();
            writer.close();
            System.out.println("Numbers and dots removed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
