package dao;

import java.sql.SQLException;

import DB.db;
import beanUrl.beanUrl;

public class DAObeanUrl {

	public static void save(beanUrl beanUrl) throws SQLException {
		try {
		String db_root = "jdbc:mysql://localhost:3306/JEE";
		String db_user = "root";
		String db_pwd = "root";
		java.sql.Connection conn = db.init(db_root,db_user,db_pwd);
		
		java.sql.PreparedStatement insertUrl = conn.prepareStatement("INSERT INTO url (url,urlShort,urlReveal) VALUES (?,?,?);");
		insertUrl.setString(1,beanUrl.getUrl()); 
		insertUrl.setString(2,beanUrl.getUrlShort()); 
		insertUrl.setString(3,beanUrl.getUrlReveal()); 
		
		insertUrl.executeUpdate();
		
		db.close(conn);
		
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	
}
