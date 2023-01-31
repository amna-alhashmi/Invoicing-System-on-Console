import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class Invoice {

	private String customerFirstName;
	private String customerLasttName;
	private Integer phoneNumber;
	private String invoiceDate;
	private Integer numberOfItems;
	private Integer totalAmount;
	private Integer paidAmount;
	private Integer balance;

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLasttName() {
		return customerLasttName;
	}

	public void setCustomerLasttName(String customerLasttName) {
		this.customerLasttName = customerLasttName;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(Integer numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Integer paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public static void createTableInvoice() {

		String url = "jdbc:mysql://localhost:3306/Text_SQL";
		String user = "root";
		String pass = "root";

		String sqlDB = "CREATE TABLE InvoiceTable " + "(id INTEGER NOT NULL AUTO_INCREMENT, "
				+ " customerFirstName VARCHAR(80)not NULL, " + "customerLastName VARCHAR(80)not NULL,"
				+ "customerFullName VARCHAR(100)not NULL," + "phoneNumber INTEGER NOT NULL ,"
				+ "invoiceDate VARCHAR(80) NOT NULL ," + "numberOfItems INTEGER NOT NULL ,"
				+ "totalAmount INTEGER NOT NULL ," + "paidAmount INTEGER NOT NULL," + "balance INTEGER NOT NULL,"
				+ "ItemsInvoice_id INTEGER  ," + "FOREIGN KEY (ItemsInvoice_id) REFERENCES itemsTable(id) ON DELETE CASCADE ,"
				+ " PRIMARY KEY ( id ))";
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			int m = st.executeUpdate(sqlDB);
			if (m >= 1) {
				System.out.println("Created table in given database...");

			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void insertIntoItems()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Scanner sa = new Scanner(System.in);
		System.out.println("PLS Enter Database URL");
		String url = sa.next();

		System.out.println("PLS Enter userName");
		String user = sa.next();

		System.out.println("PLS Enter password");
		String pass = sa.next();

		System.out.println("PLS Enter customer First Name");
		String customerFirstName = sa.next();

		System.out.println("PLS Enter customer Last Name");
		String customerLastName = sa.next();
		String CustomerFullName = customerFirstName + " " + customerLastName;

		System.out.println("PLS Enter phoneNumber");
		int phoneNumber = sa.nextInt();

		System.out.println("PLS Enter invoice Date");
		String invoiceDate = sa.next();

		System.out.println("PLS Enter Item name you want");
		String name = sa.next();
		System.out.println("Pls enter how many you give the counter?");
		int counter = sa.nextInt();

		String sqlNumberOfItems = "select COUNT(*)as Picks from itemsTable where itemName ='" + name + "'";
		String sqlTotalAmount = "select Price *(quantity) from itemsTable where itemName ='" + name + "'";
		String sqlpaidAmount = "select Price from itemsTable where itemName ='" + name + "'";
		String sqlbalance = "select Price  from itemsTable where itemName ='" + name + "'";
		String sqlItemId = "select id  from itemsTable where itemName ='" + name + "'";
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			PreparedStatement pstmt1 = con.prepareStatement(sqlNumberOfItems);
			// pstmt1.setString(1, name);
			int sqlNumberOfItems1 = 0;

			ResultSet rs = pstmt1.executeQuery();
			if (rs.next()) {
				sqlNumberOfItems1 = rs.getInt(1);
			}

			PreparedStatement pstmt2 = con.prepareStatement(sqlTotalAmount);
			// pstmt2.setString(1, name);
			int sqlTotalAmount1 = 0;

			ResultSet rs1 = pstmt2.executeQuery();
			if (rs1.next()) {
				sqlTotalAmount1 = rs1.getInt(1);
			}

			PreparedStatement pstmt3 = con.prepareStatement(sqlpaidAmount);
			// pstmt3.setString(1, name);
			int sqlpaidAmount1 = 0;

			ResultSet rs2 = pstmt3.executeQuery();
			if (rs2.next()) {
				sqlpaidAmount1 = rs2.getInt(1);
			}

			PreparedStatement pstmt4 = con.prepareStatement(sqlbalance);
			// pstmt4.setString(1, name);
			int sqlbalance1 = 0;

			int counter1 = 0;
			ResultSet rs3 = pstmt4.executeQuery();
			if (rs3.next()) {
				sqlbalance1 = rs3.getInt(1);
				counter1 = counter - sqlbalance1;
			}

			PreparedStatement pstmt5 = con.prepareStatement(sqlItemId);
			// pstmt4.setString(1, name);
			int ItemsInvoice_id = 0;

			ResultSet rs4 = pstmt5.executeQuery();
			if (rs4.next()) {
				ItemsInvoice_id = rs4.getInt("id");
			}

			// String itemName = null;
			// pstmt.setString(1, itemName);
//		try {
//			int item_id = 0;
//			ResultSet rs = pstmt1.executeQuery();
//			
//			ResultSet rs1 = pstmt2.executeQuery();
//			ResultSet rs2 = pstmt3.executeQuery();
//			ResultSet rs3 = pstmt4.executeQuery();
//			ResultSet rs4 = pstmt4.executeQuery();
//			ResultSet rs5 = pstmt5.executeQuery();
//
//
//			if (rs.next()) {
//				item_id = rs.getInt("id");
//			}

			String sqlInsert = "INSERT INTO InvoiceTable(customerFirstName,customerLastName,customerFullName,phoneNumber,invoiceDate,numberOfItems,totalAmount,paidAmount,balance,ItemsInvoice_id)VALUES(?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt6 = con.prepareStatement(sqlInsert);

			pstmt6.setString(1, customerFirstName);
			pstmt6.setString(2, customerLastName);
			pstmt6.setString(3, CustomerFullName);
			pstmt6.setInt(4, phoneNumber);
			pstmt6.setString(5, invoiceDate);
			pstmt6.setInt(6, sqlNumberOfItems1);
			pstmt6.setInt(7, sqlTotalAmount1);
			pstmt6.setInt(8, sqlpaidAmount1);
			pstmt6.setInt(9, counter1);
			pstmt6.setInt(10, ItemsInvoice_id);
			pstmt6.executeUpdate();
			System.out.println("added successfully");

			Driver driver1 = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver1);
			con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			int m = st.executeUpdate(sqlInsert);
			if (m >= 1) {
				System.out.println("Inserte table in database is success...");

			} else {
				System.out.println(" table already Inserte in given database...");
			}
			con.close();

		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void readFromInvoiceTable() {
		String url = "jdbc:mysql://localhost:3306/text_sql";
		String username = "root";
		String password = "root";

		String sqlNoOfItems = "SELECT COUNT(*)as Picks FROM itemsTable";
		String sqlNoOfInvoices = "SELECT COUNT(*)as Picks FROM InvoiceTable";
		String sqlTotalSales = "SELECT SUM(totalAmount) FROM InvoiceTable";
		// Connection, Driver, DriverRegister lines will be exactly same

		java.sql.Connection conn = null;
		try {

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			java.sql.Statement st = conn.createStatement();

			ResultSet resultSet = st.executeQuery(sqlNoOfItems);
			if (resultSet.next()) {
				do {
					System.out.println("#################################");
					System.out.println("No Of Items:" + resultSet.getInt(1));
				} while (resultSet.next());

			}
			ResultSet resultSet1 = st.executeQuery(sqlNoOfInvoices);
			if (resultSet1.next()) {
				do {
					System.out.println("No of Invoices:" + resultSet1.getInt(1));
				} while (resultSet1.next());
			}

			ResultSet resultSet2 = st.executeQuery(sqlTotalSales);
			if (resultSet2.next()) {
				do {
					System.out.println("Total Sales:" + resultSet2.getInt(1));
					System.out.println("#################################");
				} while (resultSet2.next());
			}
//			System.out.println("Item Name:"+resultSet.getString("itemName") );
//			System.out.println("unit Price:"+resultSet.getString("unitPrice") );
//			System.out.println("quantity:"+resultSet.getString("quantity") );
//			System.out.println("qty Amount:"+resultSet.getString("qtyAmount") );
//			System.out.println("Price:"+resultSet.getString("Price") );
//			System.out.println("################################" );

//		 }while (resultSet.next());

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}
	
	public static void readFromReportInvoiceTable() {
		String url = "jdbc:mysql://localhost:3306/text_sql";
		String username = "root";
		String password = "root";

		String sql = "SELECT * FROM InvoiceTable";
		// Connection, Driver, DriverRegister lines will be exactly same

		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			if(resultSet.next()) {
			 do {
				System.out.println("################################" );
				System.out.println("Invoice ID:"+resultSet.getInt(1) );
				System.out.println("invoice Date:"+resultSet.getString("invoiceDate") );
				System.out.println("customer Full Name:"+resultSet.getString("customerFullName") );
				System.out.println("number Of Items:"+resultSet.getInt("numberOfItems") );
				System.out.println("Total Amount:"+resultSet.getInt("totalAmount") );
				System.out.println("Balance:"+resultSet.getInt("balance") );
				System.out.println("################################" );

			
			 }while (resultSet.next());
			
			 
			}
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void getIdInvoice() {
		String url = "jdbc:mysql://localhost:3306/text_sql";
		String username = "root";
		String password = "root";
		Scanner scanner = new Scanner(System.in);
		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();

			Scanner sa = new Scanner(System.in);
			System.out.println("Pls Enter the id you want to search it:");
			int userin = sa.nextInt();
			String sql = "SELECT * FROM invoicetable INNER JOIN itemstable ON itemstable.id = invoicetable.ItemsInvoice_id WHERE invoicetable.id=" + userin + "";     
			ResultSet result = st.executeQuery(sql);

			
				if(result.next()) {
					do {
					System.out.println("#############################");
					
					System.out.println("Invoice ID:"+result.getInt(1));
					System.out.println("customer First Name:"+result.getString("customerFirstName"));
					System.out.println("phoneNumber:"+result.getInt("phoneNumber"));
					System.out.println("invoiceDate:"+result.getString("invoiceDate"));
					System.out.println("numberOfItems:"+result.getInt("numberOfItems"));
					System.out.println("paidAmount:"+result.getInt("paidAmount"));
					System.out.println("balance:"+result.getInt("balance"));
					
					System.out.println("#############################");
					
					System.out.println ("id :"+result.getInt("id"));
					System.out.println ("itemName :"+ result.getString("itemName"));
					System.out.println ("unitPrice :"+ result.getString("unitPrice"));
					System.out.println ("quantity :"+result.getInt("quantity"));
					System.out.println ("qtyAmount :"+ result.getInt("qtyAmount"));
					System.out.println ("Price :"+result.getInt("Price"));
					System.out.println("#############################");
					
				
					
				}while (result.next()) ;
				
				}
		}

		catch (Exception ex) {

			System.err.println(ex);

		}

	}
	
	
	
	
}
