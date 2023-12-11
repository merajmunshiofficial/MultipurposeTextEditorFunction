package TextFileProcessor;
import java.io.*;

public class FileModifier {
    public static void main(String[] args) {
    	try {
    	      File inputFile = new File("D:\\#@Doc\\Output\\merged\\Final_Merge_SpringCore - Copy.txt");
    	      File tempFile = new File("D:\\#@Doc\\Output\\merged\\Final_Merge_SpringCore - CopyTemp.txt");

    	      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    	      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

    	      String lineToRemove = "user  : ";
    	      String currentLine;

    	      while((currentLine = reader.readLine()) != null) {
    	        if(currentLine.startsWith(lineToRemove)) {
    	          if(currentLine.indexOf("user  : ", lineToRemove.length()) == -1) {
    	            continue;
    	          }
    	          else {
    	            writer.write(currentLine + System.getProperty("line.separator"));
    	          }
    	        }
    	        else {
    	          writer.write(currentLine + System.getProperty("line.separator"));
    	        }
    	      }
    	      writer.close();
    	      reader.close();
    	      boolean successful = tempFile.renameTo(inputFile);
    	    }
    	    catch(IOException e) {
    	      e.printStackTrace();
    	    }
    	  }
    	}