import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainSqlText {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Scanner sa = new Scanner(System.in);
		boolean BigMenu = true;
		boolean SubMenu = true;
		boolean SmallMenu = true;
		while (BigMenu) {
		for(String x:Menu.ShowMenu()) {
			System.out.println(x);
		}
		
			String BigMenu1 = sa.next();
			int BigMenu2 = Integer.parseInt(BigMenu1);
			switch (BigMenu2) {
			case 1:
				while (SubMenu) {
					for(String x:Menu.ShowSubMenu()) {
						System.out.println(x);
					}

					
					String SubMenu1 = sa.next();
					int SubMenu2 = Integer.parseInt(SubMenu1);
					switch (SubMenu2) {
					case 0:
						ShopDetails shope=new ShopDetails();
						shope.createTableShope();
						break;
						
					case 1:
						ShopDetails shope1=new ShopDetails();
						shope1.createTableInvoiceHeader();
						
						
						break;
						
					case 2:
						System.out.println("can you Pls choose what you want:");
						System.out.println("1.Items");
						System.out.println("2.Invoice");
						int choose = sa.nextInt();
						if(choose==1) {
							
						itemsDetails items=new itemsDetails();
						items.insertIntoItems();
						}else {
							invoiceDetails invoice1=new invoiceDetails();
							invoice1.insertIntoItems();
						}
						
						break;
						
					case 3:
						ShopDetails shope2=new ShopDetails();
						shope2.insertIntoShope();
						
						
						
						
						break;
						
					case 4:
						ShopDetails shope3=new ShopDetails();
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
					
					for(String x:Menu.ShowSubMenu1()) {
						System.out.println(x);
					}

					
					String SmallMenu1 = sa.next();
					int SmallMenu2 = Integer.parseInt(SmallMenu1);
					switch (SmallMenu2) {
					case 0:
						itemsDetails items=new itemsDetails();
						items.createTableItems();
						break;
					case 1:
						itemsDetails items1=new itemsDetails();
						items1.insertIntoItems();
						break;
						
					case 2:
						itemsDetails items2=new itemsDetails();
						items2.deleteByItems();
						break;
						
					case 3:
						itemsDetails items3=new itemsDetails();
						items3.updateByItems();
						break;
						
					case 4:
						itemsDetails items4=new itemsDetails();
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
				
				invoiceDetails invoice=new invoiceDetails();
				invoice.createTableInvoice();
				
				
				break;
				
			case 4:
				invoiceDetails invoice1=new invoiceDetails();
				invoice1.readFromInvoiceTable();
			
				break;
				
			case 5:
				invoiceDetails invoice2=new invoiceDetails();
				invoice2.readFromReportInvoiceTable();
		
				break;
				
			case 6:
				invoiceDetails invoice3=new invoiceDetails();
				invoice3.getIdInvoice();
				
				
				
				
				
				
				break;
				
			case 7:
				
				
				
				
				
				
				
				break;
				
			case 8:
				
				System.out.println("Are you sure you want to exit?");
				String exit = sa.next();
				if(exit.equals("yes")){
					System.exit(0);
					
				}else {
					 BigMenu = true;
					 SubMenu = false;
					 SmallMenu = false;
				}
				
				
				
				
				
				
				break;
		
		
		
	}
	}BigMenu=false;
		

	}

}
