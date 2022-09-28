package fetchtheDatafromDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class dash {

	public static void main(String[] args) throws SQLException {
 Driver dbdriver= new Driver();
 DriverManager.registerDriver(dbdriver);
Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/boat","root","root");
try {
	Statement sts=connection.createStatement();
	ResultSet ret=sts.executeQuery("select*from rahul");
	while (ret.next()) {
		
		System.out.println(ret.getString("emp_id"));
	}
	}
finally {
	connection.close();
}

}
	
}
