package RadFromHtml;

import com.itextpdf.html2pdf.HtmlConverter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HTMLToPDFConverter {
    public static void main(String[] args) throws IOException {
        String htmlDirectory = "C:\\Users\\Meraj.munshi\\Downloads\\New folder (2)";
        String pdfDirectory = "C:\\Users\\Meraj.munshi\\Downloads\\New folder (2)";

        File[] htmlFiles = new File(htmlDirectory).listFiles();

        for (File htmlFile : htmlFiles) {
            if (htmlFile.isFile() && htmlFile.getName().endsWith(".html")) {
                String pdfFileName = htmlFile.getName().replace(".html", ".pdf");
                File pdfFile = new File(pdfDirectory + "/" + pdfFileName);
                convertHtmlToPdf(htmlFile, pdfFile);
            }
        }
    }

    public static void convertHtmlToPdf(File htmlFile, File pdfFile) throws IOException {
        Document doc = Jsoup.parse(htmlFile, "UTF-8");
        Elements elements = doc.select("body > *");

        FileOutputStream pdfOutputStream = new FileOutputStream(pdfFile);
        HtmlConverter.convertToPdf(elements.toString(), pdfOutputStream);
        pdfOutputStream.close();
    }
}