package fileup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class fetchthedata {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step1=connect the physical file into java readable object
	FileInputStream	fil=new FileInputStream("./src/main/resources/Boo.xlsx");
	
	//step2=open the excel workbook
	 Workbook wb=WorkbookFactory.create(fil);
	 
	 //step3=get the control on sheet
	 Sheet ss= wb.getSheet("Sheet1");
	 
	 //step4=get the control on row      
    Row row = ss.getRow(1);
    //step5=get the control on cell
    Cell cell = row.getCell(0);
    //step6=fetch the data
    String usr = cell.getStringCellValue();
    System.out.println(usr);
    //step7=close the workbook
    wb.close();
	}
}
