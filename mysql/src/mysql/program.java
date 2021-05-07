package mysql;

import java.sql.*;
import java.io.*;

public class program {
	public static void main(String[] args) {
		try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/email","root","root");
				System.out.print("Connected");
				String q="insert into contacts(attachment) values(?) ";
				PreparedStatement pstmt = con.prepareStatement(q);
				FileInputStream fis = new FileInputStream("new.jpg");
		    	pstmt.setBinaryStream(1, fis,fis.available());
		    	pstmt.executeUpdate();
		    	con.close();
		}catch(Exception e) {
			System.out.println("Error");
		}
	}
	
}
