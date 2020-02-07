package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.testng.annotations.Test;

public class SQLServerConnection {

	@Test
	public void testmethod()
	{
		ResultSet rs = null;
		try
		{
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;database=Employee;integratedSecurity=true;");
			System.out.println("connected");
			Statement statement = conn.createStatement();
			rs = statement.executeQuery("select * from EmployeeDetails");

			//ResultSetMetaData metadata = rs.getMetaData();
			//int numColumns = metadata.getColumnCount();

			while(rs.next()) 
			{			
				System.out.println("");
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
			}
			System.out.println(rs);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("test medho");
	}

}
