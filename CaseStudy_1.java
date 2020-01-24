import java.io.*;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class CaseStudy_1
{

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String c;
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");//to register driver class
		Connection con=null;//connection object is initialized as null
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy","root","");//to get the connection of database
		Statement st=con.createStatement();
		do
		{
			System.out.println("\nMenu\n1. Registraion\n2. Display\n3. Exit\nEnter your Choice");
            int n=sc.nextInt();
			switch(n)
			{
				case 1: System.out.println("Name: ");
						String name=br.readLine();
						System.out.println("Address: ");
						String address=br.readLine();
						System.out.println("contact number: ");
						String cnum=br.readLine();
						System.out.println("Email : ");
						String email=br.readLine();
						System.out.println("Proof Type: ");
						String ptype=br.readLine();
						System.out.println("Proof ID: ");
						String pid=br.readLine();
						
						String s = "INSERT INTO Registration VALUES('"+name+"','"+address+"','"+cnum+"','"+email +"','"+ptype +"','"+pid +"')";
						st.execute(s);
						break;
				case 2: String s1="SELECT * FROM Registration";
				        ResultSet rs =st.executeQuery(s1);
				        System.out.println("Name\t\t\t Address\t\tPhone_no\t\tEmail\t\tProof_Type\t\t Proof_ID ");
				        while(rs.next())
				        {
				        String Name=rs.getString("Name");
				        String Address=rs.getString("Address");
				        String Phone_no=rs.getString("Contact_Number");
				        String Email_ID=rs.getString("Email_ID");
				        String Proof_Type=rs.getString("Proof_Type");
				        String Proof_Id=rs.getString("Proof_ID");
				        System.out.println(Name+"\t\t" +Address+"\t\t"+Phone_no+"\t\t"+Email_ID+"\t\t"+Proof_Type+"\t\t"+Proof_Id );
					       		
				        	
				        }
					  	break;
				case 3: System.exit(0);	
				default : System.out.println("Invalid Input");
			}
			 System.out.println("Do you want to continue registrati1on ?(yes/no)");
             c=br.readLine();
        }while(c.equals("yes"));
		
	
	}

}
