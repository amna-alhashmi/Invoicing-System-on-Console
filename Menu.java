import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	public static List<String> ShowMenu() {
		return Arrays.asList
				("1-Shop Settings",
				"2-Manage Shop Items",
				"3-Create New Invoice",
				"4-Report: Statistics",
				"5-Report: All Invoices",
				"6-Search (1) Invoice",
				"7-Search (1) Invoice",
				"8-Program Statistics",
				"9-Exit");
		

}
	
	public static List<String> ShowSubMenu (){
		return Arrays.asList
				("0-Create Shope",
			"1-Create Invoice Header",
			"2-Load Data (Items and invoices)",
			"3-Set Shop Name",
			"4-Set Invoice Header (Tel / Fax / Email / Website)",
			"5-Go Back");
}
	
	public static List<String> ShowSubMenu1 (){
		return Arrays.asList
			("0-Create Items",
			"1-Add Items",
			"2-Delete Items",
			"3-Change Item Price",
			"4-Report All Items",
			"5-Go Back");
	
	
	
}
}