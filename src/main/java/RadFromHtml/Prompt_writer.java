package RadFromHtml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prompt_writer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the output file path
        System.out.print("Enter the output file path: ");
        String outputFilePath = scanner.nextLine();

        // Prompt the user to enter the topic file path
        System.out.print("Enter the topic file path: ");
        String topicFilePath = scanner.nextLine();

        // Asking for technology
        System.out.print("Enter the technology: ");
        String technology = scanner.nextLine();

        List<String> topics = readTopicsFromFile(topicFilePath);

        try {
            FileWriter writer = new FileWriter(outputFilePath);

            for (String topic : topics) {
                // Perform some manipulation on the topic
                String processedTopic = topic.trim();

                // Generate interview questions based on the topic and technology
                String interviewQuestion = generateInterviewQuestion(processedTopic, technology);

                // Write the interview question to the output file
                writer.write(interviewQuestion + "\n");
            }

            writer.close();
            System.out.println("File processing complete!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readTopicsFromFile(String filePath) {
        List<String> topics = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(new File(filePath));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Add the topic to the list
                topics.add(line);
            }
            fileScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return topics;
    }

    private static String generateInterviewQuestion(String topic, String technology) {
        return "Generate Interview Questions regarding \"" + topic /* + "\" in " + technology*/;
    }
    //copy method for use of project ideas
    private static String generateInterviewQuestion2(String topic, String technology) {
        return "Generate enterprise-level Java console project ideas on \"" + topic + "\" in " + technology;
    }
    private static String generateInterviewQuestion3(String topic, String technology) {
        return  topic +" in " + technology; //for bard ai
    }
    private static String generateInterviewQuestion4(String topic, String technology) {
        return "generate html code to explain \"" + topic + "\" in " + technology; //for css
    }
    private static String generateInterviewQuestion5(String topic, String technology) {
        return "generate 3 example sentence using this word  \"" + topic + "\" in " + technology; //for css
    }
}
