package TextFileProcessor;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelMergeCellsExample {
    public static void main(String[] args) {
        // Create a new Excel workbook and sheet
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Create a heading row
            Row headingRow = sheet.createRow(0);

            // Create cell styles for the headings
            CellStyle headingStyle = workbook.createCellStyle();
            headingStyle.setAlignment(HorizontalAlignment.CENTER);
            headingStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            headingStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headingStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            Font font = workbook.createFont();
            font.setBold(true);
            headingStyle.setFont(font);

            // Create merged cells for each heading
            Cell cell1 = headingRow.createCell(0);
            cell1.setCellValue("Heading 1");
            cell1.setCellStyle(headingStyle);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));

            Cell cell2 = headingRow.createCell(3);
            cell2.setCellValue("Heading 2");
            cell2.setCellStyle(headingStyle);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 3, 5));

            Cell cell3 = headingRow.createCell(6);
            cell3.setCellValue("Heading 3");
            cell3.setCellStyle(headingStyle);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 8));

            // Write the Excel data to a file
            try (FileOutputStream fileOut = new FileOutputStream("D:\\Office_vid\\workbook.xlsx")) {
                workbook.write(fileOut);
            }

            System.out.println("Excel file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
