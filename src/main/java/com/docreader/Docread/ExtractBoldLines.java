package com.docreader.Docread;

import java.io.*;
import java.net.URL;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractBoldLines {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the URL of the webpage: ");
        String url = scanner.nextLine();
        System.out.print("Enter the name of the output file: ");
        String fileName = scanner.nextLine();
        scanner.close();

        Document doc = Jsoup.connect(url).get();
        Elements boldElements = doc.select("b");
        String boldText = "";
        for (Element element : boldElements) {
            boldText += element.text() + "\n";
        }

        FileWriter writer = new FileWriter(fileName);
        writer.write(boldText);
        writer.close();

        System.out.println("The bold lines have been extracted and written to " + fileName + ".");
    }
}