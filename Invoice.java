import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

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


}
