import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Items {
	private static String ShopeName;
	 String itemId;
	 String itemName;
	 String unitPrice;
	 Integer quantity;
	 Integer qtyAmount;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQtyAmount() {
		return qtyAmount;
	}

	public void setQtyAmount(Integer qtyAmount) {
		this.qtyAmount = qtyAmount;
	}

	public static void createTableItems() {
		String url = "jdbc:mysql://localhost:3306/text_sql";
		String user = "root";
		String pass = "root";

		String sqlDB = "CREATE TABLE itemsTable " + "(id INTEGER NOT NULL AUTO_INCREMENT, " + "itemId VARCHAR(20),"
				+ "itemName VARCHAR(20)," + "unitPrice VARCHAR(20)," + "quantity INTEGER NOT NULL ,"
				+ "qtyAmount INTEGER NOT NULL ," + "Shope_id INTEGER  ,"
				+ "FOREIGN KEY (Shope_id) REFERENCES ShopeTable(id) ON DELETE CASCADE ," + " PRIMARY KEY ( id ))";

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

public static void insertIntoItems() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
	
			Scanner sa = new Scanner(System.in);
			System.out.println("PLS Enter item Id");
			String item_Id = sa.next();
			
			System.out.println("PLS Enter item Name");
			String item_Name = sa.next();
			
			System.out.println("PLS Enter unit Price");
			String unitPrice = sa.next();
			
			System.out.println("PLS Enter quantity");
			int quantity = sa.nextInt();
			
			System.out.println("PLS Enter qtyAmount");
			int qtyAmount = sa.nextInt();
			
			System.out.println("PLS Enter shope name you want");
			String name = sa.next();
			
			String sql = "select id  from ShopeTable where ShopeName ='" + name + "'";
			Connection con = null;
			
			String url = "jdbc:mysql://localhost:3306/Text_SQL";
			String user = "root";
			String pass = "root";
			try {
				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				// Registering drivers
				DriverManager.registerDriver(driver);
				// Reference to connection interface
				con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				//pstmt.setString(1, ShopeName);
				try {
					int shope_id = 0;
					ResultSet rs = pstmt.executeQuery();
					
					if (rs.next()) {
						shope_id = rs.getInt("id");
					}
				
			sql = "INSERT INTO itemsTable(itemId,itemName,unitPrice,quantity,qtyAmount,Shope_id)VALUES(?,?,?,?,?,?)";
			try {
				PreparedStatement pstmt3 = con.prepareStatement(sql);
				
				pstmt3.setString(1,item_Id);
				pstmt3.setString(2,item_Name);
				pstmt3.setString(3,unitPrice);
				pstmt3.setInt(4, quantity);
				pstmt3.setInt(5, qtyAmount);
				pstmt3.setInt(6, shope_id);
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
			
}catch(SQLException e){
		System.out.println(e);
	}

}
}
