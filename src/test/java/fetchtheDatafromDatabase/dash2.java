package fetchtheDatafromDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class dash2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver db=new Driver();
		DriverManager.registerDriver(db);
Connection cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/boat","root","root");
try {
 Statement st=cnn.createStatement();
 int result=st.executeUpdate("insert into rahul values(1066,'vijay',444442155,'mumbai');");
	
} finally {
	// TODO: handle finally clause
	cnn.close();
	
}
	}

}
