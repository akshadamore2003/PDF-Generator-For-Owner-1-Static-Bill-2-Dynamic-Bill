import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
public class StaticBilling 
{
  private static final String FilePath = "D:\\a.pdf";
  PDDocument invc;
 
  String CustName;
  String CustPh;
  
  String ProductName ="";
  int ProductPrice =0;
  int ProductQty = 0;

  int total = 0;
  
  String InvoiceTitle = new String("!! GovindDham Super Shoppy !!");
  String SubTitle = new String("Invoice");
  PDPage newpage;
  
  StaticBilling() throws IOException 
  {
    invc = new PDDocument();
    newpage = new PDPage();
    invc.addPage(newpage);
  }
  
  void getdata() 
  {
    CustName = "Om Prakash Varma";
    CustPh = "8978675645";
    ProductName="Kurkure";
    ProductPrice=20;
    ProductQty=5;
    total = ProductPrice*ProductQty;
  }
  
  void WriteInvoice() throws Exception 
  { 
    try 
    {
      PDPageContentStream cs = new PDPageContentStream(invc, newpage);
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 20);
      cs.newLineAtOffset(140, 750);
      cs.showText(InvoiceTitle);
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 18);
      cs.newLineAtOffset(270, 690);
      cs.showText(SubTitle);
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.setLeading(20f);
      cs.newLineAtOffset(60, 610);
      cs.showText("Customer Name: ");
      cs.newLine();
      cs.showText("Phone Number: ");
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.setLeading(20f);
      cs.newLineAtOffset(170, 610);
      cs.showText(CustName);
      cs.newLine();
      cs.showText(CustPh);
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.newLineAtOffset(80, 540);
      cs.showText("Product Name");
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.newLineAtOffset(200, 540);
      cs.showText("Unit Price");
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.newLineAtOffset(310, 540);
      cs.showText("Quantity");
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.newLineAtOffset(410, 540);
      cs.showText("Price");
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 12);
      cs.setLeading(20f);
      cs.newLineAtOffset(80, 520);
      cs.showText(ProductName);
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 12);
      cs.setLeading(20f);
      cs.newLineAtOffset(200, 520);
      cs.showText(ProductPrice+"");
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 12);
      cs.setLeading(20f);
      cs.newLineAtOffset(310, 520);
      cs.showText(ProductQty+"");
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 12);
      cs.setLeading(20f);
      cs.newLineAtOffset(410, 520);
      cs.showText(total+"");
      cs.endText();
                  
      cs.close();
      invc.save(FilePath);
      
    }
    catch (IOException e) 
    {
      e.printStackTrace();
    }
  }
  
  
  public static void main(String args[]) throws Exception 
  {
    StaticBilling i = new StaticBilling();
    i.getdata();
    i.WriteInvoice();
    System.out.println("Invoice Generated!");
  }
}