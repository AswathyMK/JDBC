package sales;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class CaseStudy2_Buysell 
{
	public boolean buysell() throws ClassNotFoundException, SQLException
	{
		System.out.println("1.buysell");
		Scanner sc= new Scanner(System.in);
		CaseStudy2_ConnectionManager cm=new CaseStudy2_ConnectionManager();  
        String sql1="SELECT pro_minsell,pro_price from add_product where product_id=?";
        Statement st1=cm.getConnection().createStatement(); 
        ResultSet rs1=st1.executeQuery(sql1);
        while(rs1.next())
        {
        	int ch=rs1.getInt("pro_minsell");
            {
            	int minsell=1;
            	if(ch>=minsell)
            	{
            		int id=0;
            		price(id,minsell);
            		int x=sc.nextInt();
            		if(x==1)
            		{
            			String sql="Update product set minsell="+ch+-minsell+"where product_id="+id+"";
            			PreparedStatement st=(PreparedStatement) cm.getConnection().prepareStatement(sql);
            			st.executeUpdate();
            			System.out.println("Your booking is confirmed\n Thank you...");
            		}
            	}else 
            	{
            		System.out.println("The stock is not available choose less or different product");
            	}
            	cm.getConnection().close();
            	
            }
        }
     	  
        return false;
	}
	private boolean price(int id, int minsell) throws ClassNotFoundException, SQLException
	{
		CaseStudy2_ConnectionManager cm=new CaseStudy2_ConnectionManager();  
        String sql1="SELECT price from product where product_id="+id+"";
        Statement st1=cm.getConnection().createStatement(); 
        ResultSet rs1=st1.executeQuery(sql1);
        while(rs1.next())
        {
        	Float cost=rs1.getFloat("price");
		    cost=minsell*cost;
		    System.out.println("Cost is:"+cost+"\nEnter 1 to confirm Booking");
        }
		return false;
		
	}
	private boolean display(int id) throws SQLException, ClassNotFoundException
	{
		CaseStudy2_ConnectionManager cm=new CaseStudy2_ConnectionManager();
		String sql="Select price from product where product_id="+id+"";
		Statement st=cm.getConnection().createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
		
		    System.out.println(rs.getInt("product_id")+""+rs.getString("product_name")+""+rs.getFloat("minsell")+""+rs.getFloat("price")+"");
		}
     	 cm.getConnection().close(); 
		return true;
		
	}

}
