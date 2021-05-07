package dmbs;

import java.util.*;
import java.sql.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;

public class program {
	public static void main(String[] args) {
		//JDBC url and user password for databsse connection
		String jdbcURL = "jdbc:postgresql://localhost:5432/email";
		String username = "postgres";
        String password = "dhruvkaith";
       
        Scanner sc= new Scanner(System.in); 

        //specifing where we want to create pdf
        String filename = "A:\\email\\pdf\\new.pdf";
        Document document = new Document();
        
        System.out.println("Enter client's name: ");
        String name= sc.nextLine();  
        System.out.println("Enter client's email: ");
        String client_email= sc.nextLine();  
        try {
        	
        	OutputStream file = new FileOutputStream(new File(filename));
            //PdfWriter.getInstance(document, new FileOutputStream(new File(filename)));
            PdfWriter.getInstance(document, file);
            document.open();
         
           Paragraph p = new Paragraph();
            p.add("Name "+ name);
          //  p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            Paragraph p2 = new Paragraph();
            p2.add("Your email "+client_email); //no alignment
            p2.add("Recieved from CarbonatedFiji");
            document.add(p2);
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(8);
            document.add(new Paragraph("This is my paragraph 3", f));
           // document.add(Image.getInstance("A:\\sample.png"));
            document.close();
            System.out.println("PDF generated");
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
       try {
    	   Connection connection =  DriverManager.getConnection(jdbcURL, username, password);
    	   System.out.println("Connected ");
    	   
    	   String sql = "INSERT INTO record VALUES (?,?)";
    	   
    	   //Statement statement = connection.createStatement();
    	   PreparedStatement pstmt = connection.prepareStatement(sql);
    	   
    	   pstmt.setString(1, name);
    	   FileInputStream fis = new FileInputStream("A:\\email\\pdf\\new.pdf");
    	   pstmt.setBinaryStream(2, fis,fis.available());
    	   pstmt.executeUpdate();
    	 /*  int rows = statement.executeUpdate(sql);
    	   if (rows > 0) {
    		   System.out.print("A new entry is entered");
    	   }*/
    	   connection.close();

       } catch(SQLException | IOException e) {
    	   System.out.println("Error in connecting to databse");
    	   e.printStackTrace();
       }
	}


}
