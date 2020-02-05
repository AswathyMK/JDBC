package sales;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class CaseStudy2_ConnectionManager
{
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		con=(Connection)DriverManager.getConnection("jdbc:mysql://127.0.01:3306/casestudy","root","");
		if(con!=null)
		{
			return con;
			
		}else
		{
			return null;
		}
	}
	public Statement CreateStatement()
	{
		return null;
	}

	
}
