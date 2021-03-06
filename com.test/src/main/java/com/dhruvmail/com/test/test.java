package com.dhruvmail.com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class test {

	public static void main(String[] args) throws DocumentException  {
		String filename = "A:\\email\\invoice.pdf";
		Rectangle pageSize = new Rectangle(780, 525);
		Document document = new Document(pageSize);
		OutputStream file = null;
		try {
			file = new FileOutputStream(new File(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PdfWriter.getInstance(document, file);
		//PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		float[] colsWidth1 = {1f, 1f, 1f,1f,1f}; // Code 1
		//Image image = Image.getInstance(path+"employee/payslip/view/fly-hind.jpg");
		PdfPTable table = new PdfPTable(colsWidth1);
		table.getDefaultCell().setBorder(0);
		table.setWidthPercentage(100); // Code 2
		table.setHorizontalAlignment(Element.ALIGN_LEFT);//Code 3
		table.addCell("");
		table.addCell("");
		table.addCell("This is a genaric PDF");
		table.addCell("");
		table.addCell("");
		document.add(table);
		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );
		float[] colsWidth_main = {1f, 1f, 1f}; // Code 1
		table = new PdfPTable(colsWidth_main);
		table.getDefaultCell().setBorder(0);
		table.setWidthPercentage(100); // Code 2
		table.setHorizontalAlignment(Element.ALIGN_LEFT);//Code 3
		table.addCell("");
		try {
			table.addCell(Image.getInstance("A:\\email\\images\\birds.jpg"));
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.addCell("");
		document.add(table);
		float[] colsWidth = {1f, 1f, 1f, 1f}; // Code 1
		table = new PdfPTable(colsWidth);
		table.getDefaultCell().setBorder(0);
		table.setWidthPercentage(100); // Code 2
		table.setHorizontalAlignment(Element.ALIGN_LEFT);//Code 3
		//table.addCell("Employee ID");
		//table.addCell("00000");
		table.addCell("Name");
		table.addCell("00000");
		table.addCell("Recieved from");
		table.addCell("00000");
		table.addCell("Designation");
		table.addCell("00000");
		table.addCell("Email of sender");
		table.addCell("CarbonatedFiji@gmail.com");
		table.addCell("This is a gernaric table heading");
		table.addCell("0000");
		table.addCell("This is a gernaric table heading");
		table.addCell("0000");

		
		document.add(table);
		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );
		
		Paragraph p = new Paragraph();
		//p.add("This is a genaric sentance");
		
        //  p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        Paragraph p2 = new Paragraph();
        p2.add("The birds on the top are a JPG "); //no alignment
    	document.add( Chunk.NEWLINE );
       
        document.add(p2);
	
		document.close();

	}

}
