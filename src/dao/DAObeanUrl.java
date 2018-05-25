package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.db;
import beanUrl.beanUrl;

public class DAObeanUrl {
	
	public static Connection initDB() {
		String db_root = "jdbc:mysql://localhost:3306/JEE";
		String db_user = "root";
		String db_pwd = "root";
		try {
			java.sql.Connection conn = db.init(db_root,db_user,db_pwd);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void save(beanUrl beanUrl) throws SQLException {
		try {
		java.sql.Connection	conn= initDB();
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
	
	public static ArrayList<beanUrl> getAllUrl() {
		try {
			java.sql.Connection	conn= initDB();
			String strQuery = "SELECT * FROM url;";

			java.sql.Statement stSelect = conn.createStatement();
			
			ResultSet rsSelect = stSelect.executeQuery(strQuery);
			
			ArrayList<beanUrl> listUrl = new ArrayList<beanUrl>();
			
			while(rsSelect.next()) {
				 beanUrl beanUrl = new beanUrl();
				 beanUrl.setUrl(rsSelect.getString(1));
				 beanUrl.setUrlShort(rsSelect.getString(2));
				 beanUrl.setUrlReveal(rsSelect.getString(3));
				
				 listUrl.add(beanUrl);
			 }
			
			db.close(conn);
			
			return listUrl;
			
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		return null;
	}
	
}
