package zooo;

import java.util.Map;

import genericutility.excelutility;
import genericutility.iconstantpath;

public class basictofetchonedateusingget {
	public static void main(String[] args){
		//ferch the data from the excel
			excelutility excelutility = new excelutility();
			excelutility.openexcelpage(iconstantpath.excelpath);
			Map<String, String> data = excelutility.getdatafromexcelusingmap("Sheet1");
			System.out.println(data);
			System.out.println(data.get("j"));
		System.out.println();
}
}