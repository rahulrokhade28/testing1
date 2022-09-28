package genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class is consists all common action on excel
 * @author Admin
 *
 */

public class excelutility {
	
	Workbook page;
	 
	//accessSpecifer modifier returnType methodName (parameter){}
	//In accessSpecifer->public ,private, default,protected
	//modifier-> static, non-static
	// returnType->primitive and class type
// methodName-> followncameCase->and give meaningfull name
	//parameter->its is optional ->based on the statement input
	/**
	 * this method is used to fetch the data from the excel
	 * @param excelpath
	 * @param sheetname
	 * @param row no
	 * @param cell no
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @use return
	 */
	public String getDatafromExcel(String exlpath, String sheetname,int rowno,int cellno) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(exlpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Workbook work=null ;
		try {
			work = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Sheet sheet = work.getSheet(sheetname);
		 String data = new DataFormatter().formatCellValue(sheet.getRow(rowno).getCell(cellno));
		 return data;
	}
	public Workbook openexcelpage(String excel) {
		FileInputStream file=null;
		try {
		file=new FileInputStream(excel);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		try {
			page=WorkbookFactory.create(file);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
	
	
	public String getDatafromExcelsloop( String sheetname,String requiredkey,String testcasename) {
		Sheet sheet = page.getSheet(sheetname);
		String value=null;
		for(int i=0;i<sheet.getLastRowNum();i++) {
			String actualtestname=sheet.getRow(i).getCell(0).getStringCellValue();
			if(actualtestname.equalsIgnoreCase(testcasename)) {
				for(int j=1; j<sheet.getRow(i).getLastCellNum();j++) {
					String actualkey=sheet.getRow(i).getCell(j).getStringCellValue();
					if(actualkey.equalsIgnoreCase(requiredkey))
						value=sheet.getRow(i+1).getCell(j).getStringCellValue();
					break;
				}
				break;
			}
		}
		return value;
		}
	public Map<String, String> getdatafromexcelusingmap(String sheetname){
		Sheet bookmp = page.getSheet(sheetname);
		HashMap map = new HashMap<>();
		DataFormatter df=new DataFormatter();
		for(int i=0;i<=bookmp.getLastRowNum();i++) {
			map.put(df.formatCellValue(bookmp.getRow(i).getCell(0)),df.formatCellValue(bookmp.getRow(i).getCell(1)));
		}
		return map;
	}
	public List<Map<String, String>> fetchgetdatafromexcelusinglistmap(String sheetname){
		Sheet paper = page.getSheet(sheetname);
	ArrayList<Map<String, String>> listmap = new ArrayList<Map<String,String>>();
		DataFormatter df=new DataFormatter();
		for(int j=1;j<paper.getRow(0).getLastCellNum();j++) {
			Map<String,String>map=new HashMap<String,String>();
			for(int i=0;i<=paper.getLastRowNum();i++) {
				map.put(df.formatCellValue(paper.getRow(i).getCell(0)),df.formatCellValue(paper.getRow(i).getCell(j)));
			}
			listmap.add(map);
		}
		return listmap ;
	}
			
	
}
