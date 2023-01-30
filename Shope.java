import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Shope {
	
	private String ShopeName;
	private Integer tel;
	private String fax;
	private String Email;
	private String Website;
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
	
	public String getShopeName() {
		return ShopeName;
	}
	public void setShopeName(String shopeName) {
		ShopeName = shopeName;
	}


	public static void createTableShope() {

		String url = "jdbc:mysql://localhost:3306/Text_SQL";
		String user = "root";
		String pass = "root";

		String sqlDB = "CREATE TABLE ShopeTable " + "(id INTEGER NOT NULL AUTO_INCREMENT, " + " ShopeName VARCHAR(80)NOT NULL, "
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
	public static void insertIntoShope() {
		try {
			String url = "jdbc:mysql://localhost:3306/Text_SQL";
			String user = "root";
			String pass = "root";
			
//			Scanner sa = new Scanner(System.in);
//			System.out.println("PLS Enter shope name");
//			int user_input = sa.nextInt();
			
			
				Scanner sa = new Scanner(System.in);
				System.out.println("PLS Enter shope name");
				String shope_name = sa.next();
				
				String sql = "INSERT INTO ShopeTable(ShopeName)"+ "values('"+shope_name+"')";

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
	
	public static void createTableInvoiceHeader() {

		String url = "jdbc:mysql://localhost:3306/Text_SQL";
		String user = "root";
		String pass = "root";

		String sqlDB = "CREATE TABLE InvoiceHeaderTable " + "(id INTEGER NOT NULL AUTO_INCREMENT,"+"tel INTEGER NOT NULL, "+"fax VARCHAR(80),"
		+"Email VARCHAR(80),"+"Website VARCHAR(80),"+"Shope_id_Details INTEGER  ,"
		+ "FOREIGN KEY (Shope_id_Details) REFERENCES ShopeTable(id) ON DELETE CASCADE ,"
				+ " PRIMARY KEY (id))";
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
	
	public static void insertIntoInvoiceHeader() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
			Scanner sa = new Scanner(System.in);
			System.out.println("PLS Enter Database URL");
			String url = sa.next();
			
			System.out.println("PLS Enter userName");
			String user = sa.next();
			
			System.out.println("PLS Enter password");
			String pass = sa.next();
			
			
			System.out.println("PLS Enter tel number");
			int tel = sa.nextInt();
			
			System.out.println("PLS Enter fax");
			String fax = sa.next();
			
			System.out.println("PLS Enter Email");
			String Email = sa.next();
			
			System.out.println("PLS Enter Website");
			String Website = sa.next();
			
				
				System.out.println("PLS Enter shope name");
				String shope_name = sa.next();
				
	
		String sql = "select id  from ShopeTable where ShopeName ='" + shope_name + "'";
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt = con.prepareStatement(sql);

			// pstmt.setString(1, ShopeName);
			try {
				int Shope_id_Details = 0;
				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					Shope_id_Details = rs.getInt("id");
				}

				sql = "INSERT INTO InvoiceHeaderTable(tel,fax,Email,Website,Shope_id_Details)VALUES(?,?,?,?,?)";
				try {
					PreparedStatement pstmt3 = con.prepareStatement(sql);

					pstmt3.setInt(1, tel);
					pstmt3.setString(2, fax);
					pstmt3.setString(3, Email);
					pstmt3.setString(4, Website);
					pstmt3.setInt(5, Shope_id_Details);
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
