import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
public class DynamicBilling 
{
  private static final String FilePath = "D:\\Dynamic.pdf";
  PDDocument invc;
  int n; 
  Integer total = 0;
  Integer price;
  String CustName;
  String CustPh;
  List<String> ProductName = new ArrayList<String>();
  List<Integer> ProductPrice = new ArrayList<Integer>();
  List<Integer> ProductQty = new ArrayList<Integer>();
  String InvoiceTitle = new String("!! GovindDham Super Shoppy !!");
  String SubTitle = new String("Invoice");
  PDPage newpage;
  DynamicBilling() throws IOException 
  {
    invc = new PDDocument();
    newpage = new PDPage();
    invc.addPage(newpage);
  }
  
  void getdata() 
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Customer Name: ");
    CustName = sc.nextLine();
    System.out.println("Enter the Customer Phone Number: ");
    CustPh = sc.next();
    System.out.println("Enter the Number of Products: ");
    n = sc.nextInt();
    System.out.println();
    for(int i=0; i<n; i++) 
    {
      System.out.println("Enter the Product Name: ");
      ProductName.add(sc.next());
      System.out.println("Enter the Price of the Product: ");
      ProductPrice.add(sc.nextInt());
      System.out.println("Enter the Quantity of the Product: ");
      ProductQty.add(sc.nextInt());
      System.out.println();
      total = total + (ProductPrice.get(i)*ProductQty.get(i));
    }
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
      for(int i =0; i<n; i++) 
      {
        cs.showText(ProductName.get(i));
        cs.newLine();
      }
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 12);
      cs.setLeading(20f);
      cs.newLineAtOffset(200, 520);
      for(int i =0; i<n; i++) 
      {
        cs.showText(ProductPrice.get(i).toString());
        cs.newLine();
      }
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 12);
      cs.setLeading(20f);
      cs.newLineAtOffset(310, 520);
      for(int i =0; i<n; i++) 
      {
        cs.showText(ProductQty.get(i).toString());
        cs.newLine();
      }
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 12);
      cs.setLeading(20f);
      cs.newLineAtOffset(410, 520);
      for(int i =0; i<n; i++) 
      {
        price = ProductPrice.get(i)*ProductQty.get(i);
        cs.showText(price.toString());
        cs.newLine();
      }
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.newLineAtOffset(310, (500-(20*n)));
      cs.showText("Total: ");
      cs.endText();
      
      cs.beginText();
      cs.setFont(PDType1Font.TIMES_ROMAN, 14);
      cs.newLineAtOffset(410, (500-(20*n)));
      cs.showText(total.toString());
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
    DynamicBilling i = new DynamicBilling();
    i.getdata();
    i.WriteInvoice();
    System.out.println("Invoice Generated!");
  }
}