package dmbs;

import java.sql.*;

public class program {
	public static void main(String[] args) {
		String jdbcURL = "jdbc:postgresql://localhost:5432/email";
		String username = "postgres";
        String password = "dhruvkaith";
       
       try {
    	   Connection connection =  DriverManager.getConnection(jdbcURL, username, password);
    	   System.out.println("Connected ");
    	   
    	   String sql = "INSERT INTO record VALUES ('Dhruv')";
    	   
    	   Statement statement = connection.createStatement();
    	  
    	   
    	   int rows = statement.executeUpdate(sql);
    	   if (rows > 0) {
    		   System.out.print("A new entry is entered");
    	   }
    	   connection.close();

       } catch(SQLException e) {
    	   System.out.println("Error in connecting to databse");
    	   e.printStackTrace();
       }
	}
}
