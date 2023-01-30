import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Invoice {
	
private String customerFullName;
private Integer phoneNumber;
private String invoiceDate;
private Integer numberOfItems;
private Integer totalAmount;
private Integer paidAmount;
private Integer balance;
public String getCustomerFullName() {
	return customerFullName;
}
public void setCustomerFullName(String customerFullName) {
	this.customerFullName = customerFullName;
}
public Integer getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(Integer phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getInvoiceDate() {
	return invoiceDate;
}
public void setInvoiceDate(String invoiceDate) {
	this.invoiceDate = invoiceDate;
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

	String sqlDB = "CREATE TABLE InvoiceTable " + "(id INTEGER NOT NULL AUTO_INCREMENT, " + " customerFullName VARCHAR(80)not NULL, "+
	"phoneNumber INTEGER NOT NULL ,"+"invoiceDate INTEGER NOT NULL ,"+"numberOfItems INTEGER NOT NULL ,"+"totalAmount INTEGER NOT NULL ,"
			+"paidAmount INTEGER NOT NULL,"+"balance INTEGER NOT NULL,"+"Items_id INTEGER  ,"
			+ "FOREIGN KEY (Items_id) REFERENCES itemsTable(id) ON DELETE CASCADE ,"+ " PRIMARY KEY ( id ))";
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


	System.out.println("PLS Enter customer Full Name");
	String customerFullName = sa.next();

	System.out.println("PLS Enter phoneNumber");
	int phoneNumber = sa.nextInt();

	System.out.println("PLS Enter invoiceDate");
	String invoiceDate = sa.next();

	System.out.println("PLS Enter number of Items");
	int numberOfItems = sa.nextInt();
	
	System.out.println("PLS Enter total Amount");
	int totalAmount = sa.nextInt();
	
	System.out.println("PLS Enter paidAmount");
	int paidAmount = sa.nextInt();
	
	System.out.println("PLS Enter balance");
	int balance = sa.nextInt();
	
	
	System.out.println("PLS Enter Item name you want");
	String name = sa.next();

	String sql = "select id  from itemsTable where itemName ='" + name + "'";
	Connection con = null;

	try {
		Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		// Registering drivers
		DriverManager.registerDriver(driver);
		// Reference to connection interface
		con = DriverManager.getConnection(url, user, pass);
		PreparedStatement pstmt = con.prepareStatement(sql);

		String itemName = null;
		pstmt.setString(1, itemName);
		try {
			int item_id = 0;
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				item_id = rs.getInt("id");
			}

			sql = "INSERT INTO itemsTable(customerFullName,phoneNumber,invoiceDate,numberOfItems,totalAmount,paidAmount,balance,item_id)VALUES(?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement pstmt3 = con.prepareStatement(sql);

				pstmt3.setString(1, customerFullName);
				pstmt3.setInt(2, phoneNumber);
				pstmt3.setString(3, invoiceDate);
				pstmt3.setInt(4, numberOfItems);
				pstmt3.setInt(5, totalAmount);
				pstmt3.setInt(5,paidAmount);
				pstmt3.setInt(5,balance);
				pstmt3.setInt(6, item_id);
				pstmt3.executeUpdate();
				System.out.println("added successfully");

				Driver driver1 = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver1);
				con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();
				int m = st.executeUpdate(sql);
				if (m >= 1) {
					System.out.println("Inserte table in database is success...");

				} else {
					System.out.println(" table already Inserte in given database...");
				}
				con.close();

			} catch (Exception ex) {
				System.err.println(ex);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	} catch (SQLException e) {
		System.out.println(e);
	}

}

}
