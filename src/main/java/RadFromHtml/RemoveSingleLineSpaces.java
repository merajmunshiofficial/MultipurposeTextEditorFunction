package RadFromHtml;
import java.io.*;

public class RemoveSingleLineSpaces {
   public static void main(String[] args) {
      try {
         // Open the input file
         BufferedReader reader = new BufferedReader(new FileReader("D:\\#@Doc\\SpringPrompt2.txt"));
         
         // Create the output file
         BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\#@Doc\\RemoveLine_SpringPrompt2.txt"));
         
         // Read each line of the input file
         String line = reader.readLine();
         while (line != null) {
            // Remove any extra new line spaces
            line = line.trim().replaceAll("\n+", "\n");
            
            // Write the cleaned line to the output file
            writer.write(line + "\n");
            
            // Read the next line
            line = reader.readLine();
         }
         
         // Close the input and output files
         reader.close();
         writer.close();
         
         System.out.println("File cleaned successfully!");
      } catch (IOException e) {
         System.out.println("An error occurred while cleaning the file.");
         e.printStackTrace();
      }
   }
}
