package RadFromHtml;

import java.io.*;

public class HTMLMerger {

    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter the path of the HTML files to merge: ");
            String inputPath = consoleReader.readLine();
            System.out.print("Enter the name of the merged output file: ");
            String outputFileName = consoleReader.readLine();
            
            File[] htmlFiles = new File(inputPath).listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".html");
                }
            });
            
            if (htmlFiles == null || htmlFiles.length == 0) {
                System.out.println("No HTML files found in the specified path.");
                return;
            }
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                for (File htmlFile : htmlFiles) {
                    BufferedReader reader = new BufferedReader(new FileReader(htmlFile));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line); // Write each line of the HTML file to the output file
                    }
                    reader.close();
                }
                System.out.println("Merged HTML files successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
