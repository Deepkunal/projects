package com.contactUs;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RequestDao
{
	
	Connection con=null;
	
	public List<RequestModel> fetch() throws SQLException 
	{
	 	String sq="SELECT * FROM contact";
	 	Statement stmt=con.createStatement();
		 ResultSet rs= stmt .executeQuery(sq);
		 
		 List<RequestModel>listRequestModel=new ArrayList<>();
		 
		 while(rs.next())
		 {
			 RequestModel rm= new RequestModel();
			 rm.setFullname(rs.getString(1));
			 rm.setEmail(rs.getString(2));
			 rm.setMessage(rs.getString(3));
			 rm.setStatus(rs.getString(4));
			 
			 listRequestModel.add(rm);
			 
			 
		 }
		 
		 return listRequestModel;
	}
	
	
	    RequestDao() throws SQLException, ClassNotFoundException
    {
    	Class.forName("org.postgresql.Driver");

        System.out.println("Driver loaded");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Contactus","root","Deep@12345");
  
    	
    }
   public void insert(String fullname, String email ,String Message)
   {
	   
	   String sql="insert into contact values(?,?,?)";  
	  try
	  {
		  
		   PreparedStatement ps=con.prepareStatement(sql);
			         ps.setString(1,fullname);
			         ps.setString(2,email);
			         ps.setString(3,Message);
			         ps.executeUpdate();
	  }
	      catch(Exception e)
	  {
		 System.out.println(e); 
	  }
	
    }
	    public String contact(String fullname,String email,String message) throws SQLException
	    {
	    
		Statement stmt=con.createStatement();
	    String query="insert into contact values(?,?,?)";

	    
	    return query;
}


		public void update(String email)
		{
			
			String sql = "update contact set status='active' where email=?";
			  try
			  {
				  
				   PreparedStatement ps=con.prepareStatement(sql);
					         ps.setString(1,email);
					         
					         ps.executeUpdate();
					         
					         
			  }
		      catch(Exception e)
		  {
			 System.out.println(e); 
		  }
			
		}
}