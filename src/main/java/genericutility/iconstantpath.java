package genericutility;
/**
 * 1st step
 * this interface consists all the external file path (we will store the path in this class)
 */

public interface iconstantpath {
	String projectpath=System.getProperty("user.dir");
	
	String excelpath=projectpath+"/src/main/resources/zo.xlsx";
	String propertyfiles=projectpath+"/src/main/resources/zoo.properties";
String propertyfileofnormal=projectpath+"/src/main/resources/zoonormal.properties";
}
