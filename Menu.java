import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	public static void ShowMenu(int option) {
	List<String>BigMenu= Arrays.asList("1-Shop Settings",
			"2-Manage Shop Items",
			"3-Create New Invoice",
			"4-Report: Statistics",
			"5-Report: All Invoices",
			"6-Search (1) Invoice",
			"7-Program Statistics",
			"8-Exit"); 
	 
				
		List<String> SmallMenu=Arrays.asList ("0-Create Shope",
				"1-Create Invoice Header",
				"2-Load Data (Items and invoices)",
				"3-Set Shop Name",
				"4-Set Invoice Header (Tel / Fax / Email / Website)",
				"5-Go Back");
		
			
		List<String> SmallMenu1=Arrays.asList("0-Create Items",
				"1-Add Items",
				"2-Delete Items",
				"3-Change Item Price",
				"4-Report All Items",
				"5-Go Back");
	
	 
		switch(option) {
		case 1:
			printList(BigMenu);
			break;
			
		case 2:
			printList(SmallMenu);
			break;
			
		case 3:
			printList(SmallMenu1);
			break;
		}
}	
	public static void printList(List<String>printList) {
		for(String M:printList) {
			System.out.println(M);
		}
	}
}
