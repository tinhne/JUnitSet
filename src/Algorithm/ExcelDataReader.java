package Algorithm;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataReader {
    public static List<List<Integer>> readTestData(String filePath, String sheetName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() + 1;
        int colCount = sheet.getRow(0).getLastCellNum();

        List<List<Integer>> data = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            List<Integer> rowData = new ArrayList<>();
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                rowData.add((int) cell.getNumericCellValue());
            }
            data.add(rowData);
        }

        workbook.close();
        fileInputStream.close();

        return data;
    }
}
