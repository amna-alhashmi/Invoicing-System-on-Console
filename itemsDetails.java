import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class itemsDetails {
	public static void createTableItems() {
		String url = "jdbc:mysql://localhost:3306/text_sql";
		String user = "root";
		String pass = "root";

		String sqlDB = "CREATE TABLE itemsTable " + "(id INTEGER NOT NULL AUTO_INCREMENT, "
				+ "itemName VARCHAR(20)," + "unitPrice VARCHAR(20)," + "quantity INTEGER NOT NULL ,"
				+ "qtyAmount INTEGER NOT NULL ," +"Price INTEGER NOT NULL,"+ "Shope_id INTEGER  ,"
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

	public static void insertIntoItems()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String url = " ";
		Scanner sa = new Scanner(System.in);
		try {
			System.out.println("PLS Enter Database URL");
			 url = sa.next();
		}catch (InputMismatchException e) {
			System.err.println(e);
		}

		String user=" ";
		try {
			System.out.println("PLS Enter userName");
			user = sa.next();
		}catch (InputMismatchException e) {
			System.err.println(e);
		}
		
		String pass=" ";
		try {
			System.out.println("PLS Enter password");
			pass = sa.next();
		}catch (InputMismatchException e) {
			System.err.println(e);
		}


//		System.out.println("PLS Enter item Id");
//		String item_Id = sa.next();
String item_Name="";
try {
	System.out.println("PLS Enter item Name");
	item_Name = sa.next();	
}catch (InputMismatchException e) {
	System.err.println(e);
}
	
String unitPrice="";
try {
	System.out.println("PLS Enter unit Price");
	unitPrice = sa.next();
}catch (InputMismatchException e) {
	System.err.println(e);
}
int quantity=0;	
try {
	System.out.println("PLS Enter quantity");
	quantity = sa.nextInt();
}catch (InputMismatchException e) {
	System.err.println(e);
}

int qtyAmount=0;	
try {
	System.out.println("PLS Enter qtyAmount");
	qtyAmount = sa.nextInt();
}catch (InputMismatchException e) {
	System.err.println(e);
}
int Price=0;
		try {
			System.out.println("PLS Enter Price");
			Price = sa.nextInt();
		}catch (InputMismatchException e) {
			System.err.println(e);
		}
		String name="";	
try {
	System.out.println("PLS Enter shope name you want");
	name = sa.next();

}catch (InputMismatchException e) {
	System.err.println(e);
}
	

		String sql = "select InvoiceHeaderTable.id from InvoiceHeaderTable inner join ShopeTable on ShopeTable.id = InvoiceHeaderTable.Shope_id_Details where ShopeTable.ShopeName='" + name + "'";
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt = con.prepareStatement(sql);

//			String ShopeName="";
//			pstmt.setString(1, ShopeName);
			try {
				int shope_id = 0;
				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					shope_id = rs.getInt("id");
				}

				sql = "INSERT INTO itemsTable(itemName,unitPrice,quantity,qtyAmount,Price,Shope_id)VALUES(?,?,?,?,?,?)";
				try {
					PreparedStatement pstmt3 = con.prepareStatement(sql);

					
					pstmt3.setString(1, item_Name);
					pstmt3.setString(2, unitPrice);
					pstmt3.setInt(3, quantity);
					pstmt3.setInt(4, qtyAmount);
					pstmt3.setInt(5, Price);
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

		} catch (SQLException e) {
			System.out.println(e);
		}

	}
	
	public static void deleteByItems() {

		String url = "jdbc:mysql://localhost:3306/text_sql";
		String username = "root";
		String password = "root";
		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();

			Scanner sa = new Scanner(System.in);
			System.out.println("Please Enter the id you want to delet it:");
			String enter = sa.next();
			String sql = "delete from itemsTable where id ='" + enter + "'";
			int result = st.executeUpdate(sql);

		}

		catch (Exception ex) {

			System.err.println(ex);

		}

	}
	
	
	public static void updateByItems() {

		String url = "jdbc:mysql://localhost:3306/text_sql";
		String username = "root";
		String password = "root";
		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			int user_input=0;
			Scanner sa = new Scanner(System.in);
try {
	
	System.out.println("PLS Enter the id you want to Update  :");
	user_input = sa.nextInt();
}catch (InputMismatchException e) {
	System.err.println(e);
}
int new_Item_Price=0;
			try {
				
				System.out.println("Please Enter the new Item Price");
				new_Item_Price = sa.nextInt();	
			}catch (InputMismatchException e) {
				System.err.println(e);
			}
			
			
			String sql = "UPDATE itemsTable SET Price=" + new_Item_Price +" WHERE id="
					+ user_input + "";

			int result = st.executeUpdate(sql);

		}

		catch (Exception ex) {

			System.err.println(ex);

		}

	}	
	
	public static void readFromItemsTable() {
		String url = "jdbc:mysql://localhost:3306/text_sql";
		String username = "root";
		String password = "root";

		String sql = "SELECT * FROM itemsTable";
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
				System.out.println("Item ID:"+resultSet.getString("itemId") );
				System.out.println("Item Name:"+resultSet.getString("itemName") );
				System.out.println("unit Price:"+resultSet.getString("unitPrice") );
				System.out.println("quantity:"+resultSet.getString("quantity") );
				System.out.println("qty Amount:"+resultSet.getString("qtyAmount") );
				System.out.println("Price:"+resultSet.getString("Price") );
				System.out.println("################################" );

			
			 }while (resultSet.next());
			
			 
			}
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}
}
