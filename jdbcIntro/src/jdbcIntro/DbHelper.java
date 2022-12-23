package jdbcIntro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//MySQL connection function
public class DbHelper
{
	private String userName="your MySQL userName";
	private String password="your MySQL password";
	private String dbUrl="jdbc:mysql://localhost:3306/world?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//world veritabanına bağlandı
	public Connection getConnection() throws SQLException 
	{
		return DriverManager.getConnection(dbUrl,userName,password);	
	}
	public void showErrorMessage(SQLException exception) {
		System.out.println("Error "+exception.getMessage());
		System.out.println("Error code "+exception.getErrorCode());
		
		
	}

}
