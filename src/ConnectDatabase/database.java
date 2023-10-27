package ConnectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
	public static Connection con = null;
	private static database instance = new database();
	
	public static database getInstance() {
		return instance;
	}
	public void connect() throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=QLBH;encrypt=false";

		String user = "sa";
		String pass = "sapassword";
		con = DriverManager.getConnection(url, user, pass);
		System.out.println("Connect thành công");
	}
	
	public void disconnect() {
		if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static Connection getConnection() {

		  if(con == null) {
		    throw new IllegalStateException("Chưa kết nối đến CSDL");
		  }

		return con;
	}
	
	public database() {
		  try {
		    connect();
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		}
}
