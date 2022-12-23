package jdbcIntro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.cj.xdevapi.Statement;

public class Main 
{
	

	public static void main(String[] args) throws SQLException
	{
		selectDemo();// Selection Data Function
		insertData();//Create Data Function
		updateData(); //Update Data Function
		deleteData();//Delete Data  Function
			
	}
	
	//***********************
	
	public static void updateData() throws SQLException {

		Connection connection=null;
		DbHelper helper=new DbHelper();
		PreparedStatement statement=null;
		ResultSet resultSet;
		try 
		{
			
			connection=helper.getConnection();
			String sql="Update city set population=8000 where id =4080";
			
			statement= connection.prepareStatement(sql);
			int result= statement.executeUpdate();
			System.out.println("Updated");	
		}
		catch(SQLException exception)
		{
			helper.showErrorMessage(exception);
		}

		finally {
			statement.close();
			connection.close();
		}
	}
	
	
	//***********************
	public static void deleteData() throws SQLException {
		Connection connection=null;
		DbHelper helper=new DbHelper();
		PreparedStatement statement=null;
		ResultSet resultSet;
		try 
		{
			
			connection=helper.getConnection();
			String sql="delete from city where id=?";
			statement= connection.prepareStatement(sql);
			statement.setInt(1, 4088);
			int result= statement.executeUpdate();
			System.out.println("Deleted");	
		}
		catch(SQLException exception)
		{
			helper.showErrorMessage(exception);
		}

		finally {
			statement.close();
			connection.close();
		}
		
	}
	
	//***********************
	
	public static void insertData() throws SQLException {
		Connection connection=null;
		DbHelper helper=new DbHelper();
		PreparedStatement statement=null;
		ResultSet resultSet;
		try 
		{
			
			connection=helper.getConnection();
			statement= connection.prepareStatement("insert into city (Name,CountryCode,District,Population) values('Düzce','TUR','Düzce',50000)");
			int result= statement.executeUpdate();
			System.out.println("Added");
		
			
			
		}
		catch(SQLException exception)
		{
			helper.showErrorMessage(exception);
		}

		finally {
			statement.close();
			connection.close();
		}
		
	}
	
	//***********************
	public static void selectDemo() throws SQLException  {
		Connection connection=null;
		DbHelper helper=new DbHelper();
		java.sql.Statement statement=null;
		ResultSet resultSet;
		try 
		{
			
			connection=helper.getConnection();
			System.out.println("Connection successful");
			
			statement= connection.createStatement();
			resultSet= statement.executeQuery("select Code,Name,Continent,Region from Country");
			ArrayList<Country> countries =new ArrayList<>();
			while(resultSet.next()) {
				countries.add(new Country(
						resultSet.getString("Code"),
						resultSet.getString("Name"),
						resultSet.getString("Continent"),
					    resultSet.getString("Region")));
			}
			System.out.println(countries.size());
			
			
		}
		catch(SQLException exception)
		{
			helper.showErrorMessage(exception);
		}

		finally {
			connection.close();
		}
	}


}
