package TextFileProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the input file path.");
            return;
        }

        String inputFilePath = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                createFile(line);
            }
            System.out.println("Files created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFile(String fileName) {
        try {
            String filePath = fileName + ".txt";
            File file = new File(filePath);

            // If file already exists, add a number suffix to the file name
            int i = 1;
            while (file.exists()) {
                filePath = fileName + "(" + i + ")" + ".txt";
                file = new File(filePath);
                i++;
            }

            if (file.createNewFile()) {
                FileWriter writer = new FileWriter(file);
                writer.write("This is the content of file: " + fileName);
                writer.close();
                System.out.println("File " + filePath + " created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
