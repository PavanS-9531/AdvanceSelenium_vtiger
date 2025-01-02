package org.qspiders.DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDataFromPDF {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		File file = new File("./src/test/resources/JD _Senior QA Engineer.pdf");
		PDDocument doc = PDDocument.load(file);
		int pages = doc.getNumberOfPages();
		System.out.println(pages);
		
		PDFTextStripper pdfData = new PDFTextStripper();
		//String readData = pdfData.getText(doc);
		//System.out.println(readData);
		/*
		 * pdfData.setStartPage(2); pdfData.setEndPage(5); String page2 =
		 * pdfData.getText(doc); System.out.println(page2);
		 */
		
		//To read a single page
		
		
		 pdfData.setStartPage(2); 
		 pdfData.setEndPage(2); 
		 String page3 = pdfData.getText(doc); 
		 System.out.println(page3);
		 
		

	}

}
