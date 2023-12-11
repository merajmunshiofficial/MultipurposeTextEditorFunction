package com.docreader.Docread;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoldLineExtractor2 {
    public static void main(String[] args) {
        String url = "https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#spring-core";
        String outputFile = "D:\\#@Doc\\Bolded_Text.txt";

        try {
            URL website = new URL(url);
            String content = getContent(website);
            List<String> boldSentences = getBoldSentences(content);
            FileWriter writer = new FileWriter(outputFile);

            for (String sentence : boldSentences) {
                writer.write(sentence + "\n");
            }

            writer.close();
            System.out.println("Bold sentences extracted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getContent(URL website) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
        }
        return sb.toString();
    }

    private static List<String> getBoldSentences(String content) {
        List<String> sentences = new ArrayList<>();
        Pattern pattern = Pattern.compile("<b>(.*?)</b>");
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            String boldText = matcher.group(1);
            String[] boldSentences = boldText.split("\\.");
            for (String sentence : boldSentences) {
                sentences.add(sentence.trim() + ".");
            }
        }

        return sentences;
    }
}
