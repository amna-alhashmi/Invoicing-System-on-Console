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
				System.out.println("1.Create Invoice Header");
				System.out.println("2.Load Data (Items and invoices)");
				System.out.println("3.Set Shop Name");
				System.out.println("4.Set Invoice Header (Tel / Fax / Email / Website)");
				System.out.println("5.Go Back");
				
				String SubMenu1 = sa.next();
				int SubMenu2 = Integer.parseInt(SubMenu1);
				switch (SubMenu2) {
				case 0:
					Shope shope=new Shope();
					shope.createTableShope();
					break;
					
				case 1:
					Shope shope1=new Shope();
					shope1.createTableInvoiceHeader();
					
					
					break;
					
				case 2:
					System.out.println("can you Pls choose what you want:");
					System.out.println("1.Items");
					System.out.println("2.Invoice");
					int choose = sa.nextInt();
					if(choose==1) {
					Items items=new Items();
					items.insertIntoItems();
					}else {
						Invoice invoice1=new Invoice();
						invoice1.insertIntoItems();
					}
					
					break;
					
				case 3:
					Shope shope2=new Shope();
					shope2.insertIntoShope();
					
					
					
					
					break;
					
				case 4:
					Shope shope3=new Shope();
					shope3.insertIntoInvoiceHeader();
					
					
					
					break;
				case 5:
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
					Items items1=new Items();
					items1.insertIntoItems();
					break;
					
				case 2:
					Items items2=new Items();
					items2.deleteByItems();
					break;
					
				case 3:
					Items items3=new Items();
					items3.updateByItems();
					break;
					
				case 4:
					Items items4=new Items();
					items4.readFromItemsTable();
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
			Invoice invoice1=new Invoice();
			invoice1.readFromInvoiceTable();
		
			break;
			
		case 5:
			Invoice invoice2=new Invoice();
			invoice2.readFromReportInvoiceTable();
	
			break;
			
		case 6:
			Invoice invoice3=new Invoice();
			invoice3.getIdInvoice();
			
			
			
			
			
			
			break;
			
		case 7:
			
			
			
			
			
			
			
			break;
			
		case 8:
			
			
			
			
			
			
			
			
			break;
	
	
	
}
}BigMenu=false;
}
}