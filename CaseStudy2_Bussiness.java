package sales;
import java.io.*;
import java.util.*;
import java.sql.*;
public class CaseStudy2_Bussiness
{
	Scanner sc=new Scanner(System.in);
	CaseStudy2_ConnectionManager con=new CaseStudy2_ConnectionManager();

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException 
	{
		CaseStudy2_Bussiness bussiness=new CaseStudy2_Bussiness();
		bussiness.admin();
	}
	public boolean admin() throws ClassNotFoundException, SQLException, IOException
	{
		Scanner sc=new Scanner(System.in);
		CaseStudy2_ConnectionManager con=new CaseStudy2_ConnectionManager();
		System.out.println("1.Admin");
		System.out.println("2.Agent");
		System.out.println("3.Exit");
		int x=sc.nextInt();
		CaseStudy2_Bussiness bussiness=new CaseStudy2_Bussiness();
		
		switch(x)
		{
		case 1:System.out.println("Enter username");
			   String username=sc.next();
			   System.out.println("Enter password");
			   String password=sc.next();
			   Statement st=con.getConnection().createStatement();
			   String sql;
			   sql="SELECT USERNAME,PASSWORD FROM ADMIN";
			   ResultSet rs=st.executeQuery(sql);
			   while(rs.next())
			   {
				   if(username.equals(rs.getString("username"))&&password.equals(rs.getString("password")))
				   {
					   System.out.println("Validate");
					   CaseStudy2_AddProduct addproduct=new CaseStudy2_AddProduct();
					   addproduct.addproduct();
					   con.getConnection().close();
					   return true;
				   }
				   else
				   {
					   System.out.println("Not validate");
					   con.getConnection().close();
					   return false;
				   }
			   }
			   bussiness.admin();
			   con.getConnection().close();
			   return false;
		case 2:System.out.println("Enter Agent Username");
	       	   String user=sc.next();
	       	   System.out.println("Enter Agent password");
	       	   String pass=sc.next();
	       	   CaseStudy2_ConnectionManager conn=new CaseStudy2_ConnectionManager();
	       	   Statement st1=conn.getConnection().createStatement();
	       	   String sql1;
	       	   sql1="SELECT USERNAME,PASSWORD FROM AGENT";
	       	   ResultSet rs1=st1.executeQuery(sql1);
	       	   while(rs1.next())
	       	   {
	       		   if(user.equals(rs1.getString("username"))&&pass.equals(rs1.getString("password")))
	       		   {
	       			   System.out.println("Validate");
	       			   System.out.println("1.buy/sell\n2.Display\n3.Exit");
	       			   Scanner o=new Scanner(System.in);
	       			   int y=o.nextInt();
	       			   if(y==1)
	       			   {
	       				   System.out.println("Buy/sell");
	       				   bussiness.buysell();
	       			   }else if(y==2)
	       			   {
	       				   System.out.println("Display");
	       				   bussiness.display();
	       			   }
	       			   conn.getConnection().close();
	       			   return true;
	       		   }else
	       		   {
	       			   System.out.println("Not validate");
	       			   conn.getConnection().close();
	       			   return false;
	       		   }
	       	   }
		case 3: System.out.println("Exit");
	    }
		return false;
	}
	private boolean display() throws SQLException, ClassNotFoundException
	{
		CaseStudy2_ConnectionManager cm=new CaseStudy2_ConnectionManager();
		String id=null;
		String sql="Select price from product where product_id="+id+"";
		Statement st=cm.getConnection().createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			Float cost=rs.getFloat("price");
			Float minsell=null;
		    cost=minsell*cost;
		    System.out.println("Cost is:"+cost+"\nEnter 1 to confirm booking");
		}
     	  
		return true;
		
	}
	public boolean buysell() throws SQLException, ClassNotFoundException
	{
		System.out.println("1.buysell");
		Scanner sc=new Scanner(System.in);
		CaseStudy2_ConnectionManager cm=new CaseStudy2_ConnectionManager();
		String sql1="select pro_minsell,pro_price from add_product where pro_id=1234";
		Statement st1=cm.getConnection().createStatement();
		ResultSet rs=st1.executeQuery(sql1);
		while(rs.next())
		{
			int ch=rs.getInt("pro_minsell");
			{
				int minsell=1;
				if(ch>=minsell)
				{
					int id=1234;
					price(id,minsell);
					int x=sc.nextInt();
					if(x==1)
					{
						String sql="UPDATE product set minsell ="+ch+ -minsell+"where product_id="+id+"";
						PreparedStatement st=cm.getConnection().prepareStatement(sql);
						st.executeUpdate();
						System.out.println("Your booking is confirmed\nThank you..");
					}
				}
				else
				{
					System.out.println("The stock is not available choose less or different product");
				}
				cm.getConnection().close();
			}
		}
		return false;
	
	}
	public boolean price(int id, int minsell)throws ClassNotFoundException, SQLException
	{
		CaseStudy2_ConnectionManager cm=new CaseStudy2_ConnectionManager();
		String sql="select price from product where product_id="+id+"";
		Statement st1=cm.getConnection().createStatement();
		ResultSet rs=st1.executeQuery(sql);
		while(rs.next())
		{
			Float cost=rs.getFloat("price");
			cost=minsell*cost;
			System.out.println("Cost is:"+cost+"\nEnter 1 to confirm booking");
		}
		return true;
	}
  
}
