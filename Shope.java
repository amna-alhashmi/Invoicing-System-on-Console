import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Shope {
	
	private String ShopeName;
	
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
}
