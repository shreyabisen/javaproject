package com.softronics.service;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class UserService {
	Connection con;
	String status=null;
	Statement st=null;
	ResultSet rs=null;
	
	
	public UserService()
	{
		Connection con;
		try {
			
			Class.forName("oracle.jdbc.oracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			Statement st=con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
		
	}

	public String checkLogin(String uname,String upwd)
	{
		
		try {
			rs=st.executeQuery("select *from user where uname='"+uname+"'and upwd='"+upwd+"'");
					boolean b=rs.next();
			if(b==true)
			{
				status=" success";
			}
			else {
				status="failure";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String registration(String uname,String upwd,String uemail,String uaddr)
	{
try {
	rs=st.executeQuery("select * from user1 where uname='"+uname+"','"+upwd+"','"+uemail+"'");
			
			int rowCount=st.executeUpdate("insert into user1 values(uname='"+uname+"','"+upwd+"','"+uemail+"','"+uaddr+"')");
			if(rowCount==1)
			{
				status="Success";
			}
				else
				{
					status="Failure";
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return status;
	}
	

	}


