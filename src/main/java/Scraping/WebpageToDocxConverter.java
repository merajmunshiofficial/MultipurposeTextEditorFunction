package Scraping;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebpageToDocxConverter {
  
  public static void main(String[] args) throws IOException {
    String url = "https://docs.angularjs.org/guide"; // Replace with user-provided URL
    
    Document doc = Jsoup.connect(url).get();
    
    XWPFDocument document = new XWPFDocument();
    
    Elements elements = doc.getAllElements();
    
    for (Element element : elements) {
      XWPFParagraph xwpfParagraph = document.createParagraph();
      XWPFRun xwpfRun = xwpfParagraph.createRun();
      xwpfRun.setText(element.text());
    }
    
    FileOutputStream out = new FileOutputStream("D:\\#@Doc\\merged_file.docx"); // Replace with desired output file path
    document.write(out);
    out.close();
    document.close();
    
    System.out.println("Webpage data extracted and written to docx file successfully.");
  }
  
}
