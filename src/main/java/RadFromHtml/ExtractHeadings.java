package RadFromHtml;

import java.io.*;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractHeadings {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the input HTML file: ");
        String inputFileName = scanner.nextLine();
        System.out.print("Enter the name of the output file: ");
        String outputFileName = scanner.nextLine();
        scanner.close();

        File input = new File(inputFileName);
        Document doc = Jsoup.parse(input, "UTF-8", "");

        Elements elements = doc.select("h1, h2, h3, h4, h5, h6 ");
        String headingText = "";
        for (Element heading : elements) {
            headingText += heading.text() + "\n";
        }

        FileWriter writer = new FileWriter(outputFileName);
        writer.write(headingText);
        writer.close();

        System.out.println("The elements have been extracted and written to " + outputFileName + ".");
    }
}
