import java.util.*;
import java.io.*;
import java.sql.*;
public class Main {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException
	{
		//Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name=br.readLine();
		 int age = Integer.parseInt(br.readLine());
		    
		String address=br.readLine();
		
		
		Class.forName("com.mysql.jdbc.Driver");//to register driver class
		Connection con=null;//connection object is initialized as null
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database_jdbc","root","");//to get the connection of database
		//if the connection object is not null, then a connection is established with database.
		
		if(con!=null)
		{
			
			System.out.println("Welcome");
		}
		Statement st=con.createStatement();
		String s = "INSERT INTO details VALUES('"+name+"','"+age+"','"+address+"')";
		st.execute(s);
		

	}

}
