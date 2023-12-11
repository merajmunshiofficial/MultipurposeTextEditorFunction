package com.docreader.Docread;

import java.io.*;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class BoldLineExtractor {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        String inputFilePath = "D:\\#@Doc\\CoreTechnologies.docx";
        String outputFilePath = "D:\\#@Doc\\Bolded_Text.txt";
        XWPFDocument doc = new XWPFDocument(new FileInputStream(inputFilePath));
        FileOutputStream fos = new FileOutputStream(outputFilePath);
        for (XWPFParagraph para : doc.getParagraphs()) {
            for (XWPFRun run : para.getRuns()) {
                if (run.isBold()) {
                    String text = run.getText(0);
                    if (text != null && !text.isEmpty()) {
                        fos.write(text.getBytes());
                        fos.write("\n".getBytes());
                    }
                }
            }
        }
        System.out.println("File Created ");
        fos.close();
    }
}