package sales;

import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CaseStudy2_AddProduct 
{

	public void addproduct() throws ClassNotFoundException, SQLException, IOException
	{
		CaseStudy2_ConnectionManager con=new CaseStudy2_ConnectionManager();
		Scanner sc=new Scanner(System.in);
		System.out.println("Add Product");
		System.out.println("1.add product\n 2.display product \n 3.Exit");
		int c=sc.nextInt();
		if(c==1)
		{
			System.out.println("Enter the product_Id");
			int id=sc.nextInt();
			System.out.println("Enter product_name");
			String name=sc.next();
			System.out.println("Enter product_minsell");
			int minsell=sc.nextInt();
			System.out.println("Enter product_price");
			int price=sc.nextInt();
			PreparedStatement ps=(PreparedStatement)con.getConnection().prepareStatement("INSERT INTO add_product(pro_id,pro_name,pro_minsell,pro_price,total_cost)values(?,?,?,?,?)");
			int total_cost=minsell*price;
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setInt(3, minsell);
			ps.setInt(4, price);
			ps.setInt(5, total_cost);
			ps.executeUpdate();
			con.getConnection().close();
			System.out.println("Data inserted Succesfully");
			CaseStudy2_AddProduct addproduct=new CaseStudy2_AddProduct();
			CaseStudy2_Bussiness bussiness=new CaseStudy2_Bussiness();
			bussiness.admin();
			con.getConnection().close();
		}
		else if(c==2)
		{
			System.out.println("Display Product");
			Statement st=(Statement) con.getConnection().createStatement();
			ResultSet rs=st.executeQuery("Select * from add_product");
			while(rs.next())
			{
				System.out.println("Product_Id");
				System.out.println(rs.getString("pro_id"));
				System.out.println("Product_Name");
				System.out.println(rs.getString("pro_name"));
				System.out.println("Product_Minsell");
				System.out.println(rs.getString("pro_minsell"));
				System.out.println("Product_Price");
				System.out.println(rs.getString("pro_price"));
				System.out.println("Product_Total cost");
				System.out.println(rs.getString("total_cost"));
			}
			CaseStudy2_Bussiness bussiness=new CaseStudy2_Bussiness();
			bussiness.admin();
			con.getConnection().close();
			
		}else if(c==3)
		{
			System.out.println("exit");
			System.exit(0);
			CaseStudy2_AddProduct addproduct=new CaseStudy2_AddProduct();
			addproduct.admin();
			con.getConnection().close();
			
			
		}
		sc.close();
	}

	private void admin() {
		// TODO Auto-generated method stub
		
	}
}