package fileup;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class loopfile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream("./src/main/resources/zo.xlsx");
		Workbook wb=WorkbookFactory.create(file);
		Sheet sht = wb.getSheet("Sheet1");
		DataFormatter df= new DataFormatter();
		String value=null;
		for(int i=0;i<sht.getLastRowNum();i++) {
			String key=df.formatCellValue(sht.getRow(i).getCell(0));
			if(key.equalsIgnoreCase("J")) {
				value=df.formatCellValue(sht.getRow(i).getCell(1));
				break;
			}
		}
		System.out.println(value);
	}

}
