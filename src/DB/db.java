package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
	
	public static Connection init(String db_root,String db_user,String db_pwd) throws SQLException{
		java.sql.Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 return DriverManager.getConnection(db_root, db_user,db_pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection con) throws SQLException {
		con.close();
	}
}
