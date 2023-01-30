import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
	

public static void BigMenu() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	Scanner sa = new Scanner(System.in);
	boolean BigMenu = true;
	boolean SubMenu = true;
	boolean SmallMenu = true;
	while (BigMenu) {
		System.out.println("1.Shop Settings");
		System.out.println("2.Manage Shop Items");
		System.out.println("3.Create New Invoice");
		System.out.println("4.Report: Statistics");
		System.out.println("5.Report: All Invoices");
		System.out.println("6.Search (1) Invoice");
		System.out.println("7.Program Statistics");
		System.out.println("8.Exit");
		String BigMenu1 = sa.next();
		int BigMenu2 = Integer.parseInt(BigMenu1);
		switch (BigMenu2) {
		case 1:
			while (SubMenu) {
				System.out.println("0.Create Shope");
				System.out.println("1.Load Data (Items and invoices)");
				System.out.println("2.Set Shop Name");
				System.out.println("3.Set Invoice Header (Tel / Fax / Email / Website)");
				System.out.println("4.Go Back");
				
				String SubMenu1 = sa.next();
				int SubMenu2 = Integer.parseInt(SubMenu1);
				switch (SubMenu2) {
				case 0:
					Shope shope=new Shope();
					shope.createTableShope();
					break;
					
				case 1:
					Items items=new Items();
					items.insertIntoItems();
					
					
					break;
					
				case 2:
					
					Shope shope1=new Shope();
					shope1.insertIntoShope();
					
					break;
					
				case 3:
//					invoiceHeader InvoiceHeader=new invoiceHeader();
//					InvoiceHeader.createTableInvoiceHeader();
					
					invoiceHeader InvoiceHeader1=new invoiceHeader();
					InvoiceHeader1.insertIntoInvoiceHeader();
					
					break;
					
				case 4:
					SubMenu=false;
					BigMenu=true;
					
					
					break;
		
				
				}
				}SubMenu=false;
	
	break;
		case 2:
			while (SmallMenu) {
				System.out.println("0.Create Items");
				System.out.println("1.Add Items");
				System.out.println("2.Delete Items");
				System.out.println("3.Change Item Price");
				System.out.println("4.Report All Items");
				System.out.println("5.Go Back");
				
				String SmallMenu1 = sa.next();
				int SmallMenu2 = Integer.parseInt(SmallMenu1);
				switch (SmallMenu2) {
				case 0:
					Items items=new Items();
					items.createTableItems();
					break;
				case 1:
					
					break;
					
				case 2:
					break;
					
				case 3:
					break;
					
				case 4:
					break;
					
				case 5:
					
					SmallMenu=false;
					BigMenu=true;
					
					break;
				
				
				
				}
			
			}SmallMenu=false;
			
			
			break;
			
		case 3:
			
			Invoice invoice=new Invoice();
			invoice.createTableInvoice();
			
			
			break;
			
		case 4:
			
			
			
			
			
			
			
			break;
			
		case 5:
			
			
			
			
			
			
			
			
			break;
			
		case 6:
			
			
			
			
			
			
			
			break;
			
		case 7:
			
			
			
			
			
			
			
			break;
			
		case 8:
			
			
			
			
			
			
			
			
			break;
	
	
	
}
}BigMenu=false;
}
}