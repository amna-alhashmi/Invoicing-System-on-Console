import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class invoiceHeader {
Integer tel;
String fax;
String Email;
String Website;
public Integer getTel() {
	return tel;
}
public void setTel(Integer tel) {
	this.tel = tel;
}

public String getFax() {
	return fax;
}
public void setFax(String fax) {
	this.fax = fax;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getWebsite() {
	return Website;
}
public void setWebsite(String website) {
	Website = website;
}

public static void createTableInvoiceHeader() {

	String url = "jdbc:mysql://localhost:3306/Text_SQL";
	String user = "root";
	String pass = "root";

	String sqlDB = "CREATE TABLE InvoiceHeaderTable " + "(tel INTEGER NOT NULL, "+"fax VARCHAR(80),"
	+"Email VARCHAR(80),"+"Website VARCHAR(80),"
			+ " PRIMARY KEY ( tel))";
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

public static void insertIntoInvoiceHeader() {
	try {
		String url = "jdbc:mysql://localhost:3306/Text_SQL";
		String user = "root";
		String pass = "root";
		
//		Scanner sa = new Scanner(System.in);
//		System.out.println("PLS Enter shope name");
//		int user_input = sa.nextInt();
		
		
			Scanner sa = new Scanner(System.in);
			System.out.println("PLS Enter Tel number");
			int tel = sa.nextInt();
			
			System.out.println("PLS Enter Fax");
			String Fax = sa.next();
			
			System.out.println("PLS Enter Email");
			String Email = sa.next();
			
			System.out.println("PLS Enter Website");
			String Website = sa.next();
			
			String sql = "INSERT INTO InvoiceHeaderTable(tel,fax,Email,Website)"+ "values("+tel+",'"+Fax+"','"+Email+"','"+Website+"')";

			Connection conn = null;

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			int m = st.executeUpdate(sql);
			if (m >= 1) {
				System.out.println("inserte table in database...");

			} else {
				System.out.println(" table already inserte in given database...");
			}
			conn.close();
		
	} catch (Exception ex) {
		System.err.println(ex);
	}
}



}
