package RadFromHtml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HTMLKeywordUpdater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input HTML file path
        System.out.print("Enter the path of the input HTML file: ");
        String inputFilePath = scanner.nextLine();

        // Keywords file path
        System.out.print("Enter the path of the text file containing keywords: ");
        String keywordsFilePath = scanner.nextLine();

        // Output file path
        System.out.print("Enter the path for the output HTML file: ");
        String outputFilePath = scanner.nextLine();

        try {
            // Load the HTML file
            File input = new File(inputFilePath);
            Document doc = Jsoup.parse(input, "UTF-8");

            // Read the keywords from the file
            List<String> keywords = readKeywordsFromFile(keywordsFilePath);

            // Iterate through the keywords
            for (String keyword : keywords) {
                // Find the h5 element with the specified keyword in its ID
                Elements h5Elements = doc.select("h5[id*=" + keyword + "]");

                if (!h5Elements.isEmpty()) {
                    // Add the desired code before the h5 element
                    Element targetElement = h5Elements.first();
                    targetElement.before("</div>\n\n<div class=\"page\">");

                    System.out.println("Updated HTML for keyword '" + keyword + "'.");
                } else {
                    System.out.println("No matching h5 element found for keyword '" + keyword + "'.");
                }
            }

            // Save the updated HTML as output
            FileWriter writer = new FileWriter(outputFilePath);
            writer.write(doc.outerHtml());
            writer.close();

            System.out.println("HTML file updated successfully. Output saved at: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readKeywordsFromFile(String filePath) throws IOException {
        List<String> keywords = new ArrayList<>();
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            keywords.add(line.trim());
        }

        bufferedReader.close();
        fileReader.close();

        return keywords;
    }
}

