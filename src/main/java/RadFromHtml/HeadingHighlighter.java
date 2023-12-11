package RadFromHtml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeadingHighlighter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt for the text file containing headings
        System.out.print("Enter the path of the text file containing headings: ");
        String headingsFilePath = scanner.nextLine();
        
        // Prompt for the Markdown file to be modified
        System.out.print("Enter the path of the Markdown file to be modified: ");
        String markdownFilePath = scanner.nextLine();

        try {
            List<String> headings = readHeadingsFromFile(headingsFilePath);
            highlightHeadingsInMarkdown(headings, markdownFilePath);
            System.out.println("Heading highlighting complete!");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static List<String> readHeadingsFromFile(String filePath) throws IOException {
        List<String> headings = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                headings.add(line);
            }
        }
        
        return headings;
    }
    
    private static void highlightHeadingsInMarkdown(List<String> headings, String markdownFilePath) throws IOException {
        StringBuilder markdownContent = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(markdownFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String heading : headings) {
                    if (line.contains(heading)) {
                        line = "## " + line;
                        break;
                    }
                }
                markdownContent.append(line).append("\n");
            }
        }
        
        try (FileWriter writer = new FileWriter(markdownFilePath)) {
            writer.write(markdownContent.toString());
        }
    }
    
}

