import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.IOException;
import java.lang.reflect.Method;


public class DP {
    public static object[][] getExcelData(method m) throws IOException{
        String filePath = "";
        File path = new File(filePath);
        FileInputStream file = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(m.geName());
        int rowcount = sheet.getPhysicalNumberOfRows();
        int colsCount = sheet.getRow(0).getLastCellNum();
        Object[][] arrayExcelData = new Object[rowcount-1][colsCount-1];
        DataFormatter formatter = new DataFormatter();
        for(int outer = 1;outer<rowcount;outer++){
            XSSFRow rows = sheet.getRow(outer);
            for(int inner = 1;inner<colsCount;inner++){
                XSSFCell cell = rows.getCell(inner);
                
                   arrayExcelData[outer-1][inner-1] =formatter.formatCellValue(cell);
                   
            }
        }
        workbook.close();
        file.close();
        return arrayExcelData;
        
    }

    }
    
