package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import DB.db;
import bean.beanUrl;

public class DAObeanUrl {
	
	public static Connection initDB() {
		String db_root = "jdbc:mysql://localhost:3306/JEE";
		String db_user = "root";
		String db_pwd = "root";
		try {
			java.sql.Connection conn = db.init(db_root,db_user,db_pwd);
			System.out.println(conn);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void save(beanUrl beanUrl, Integer id) throws SQLException {
		try {
			
		java.sql.Connection conn= initDB();
		java.sql.PreparedStatement insertUrl = conn.prepareStatement("INSERT INTO url (url,urlShort,urlReveal,password,keyShort,user_id, created, captcha, minDate, maxDate, maxClick) VALUES (?,?,?,?,?,?,?,?,?,?,?);");
		insertUrl.setString(1,beanUrl.getUrl()); 
		insertUrl.setString(2,beanUrl.getUrlShort()); 
		insertUrl.setString(3,beanUrl.getUrlReveal()); 
		insertUrl.setString(4,beanUrl.getPassword());
		insertUrl.setString(5, beanUrl.getKeyShort());
		insertUrl.setInt(6, id);
		java.util.Date today = new java.util.Date();
		java.sql.Date date = new java.sql.Date(today.getTime());
	
		insertUrl.setDate(7, date);
		
		insertUrl.setBoolean(8, beanUrl.isCaptcha());
		
		Date minDateUrl = beanUrl.getMinDate();
		
		if(minDateUrl != null) {
			java.util.Date minDate = minDateUrl;
			java.sql.Date sqlMinDate = new java.sql.Date(minDate.getTime());
			insertUrl.setDate(9, sqlMinDate);
		}else {
			insertUrl.setDate(9, null);
		}
		
		Date maxDateUrl = beanUrl.getMaxDate();
		
		if(maxDateUrl != null) {
			java.util.Date maxDate = maxDateUrl;
			java.sql.Date sqlMaxDate = new java.sql.Date(maxDate.getTime());
			insertUrl.setDate(10, sqlMaxDate);
		}else {
			insertUrl.setDate(10, null);
		}
		
	
	
		
		
		insertUrl.setInt(11, beanUrl.getMaxClick());
		
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
				 beanUrl.setUrl(rsSelect.getString(2));
				 beanUrl.setUrlShort(rsSelect.getString(3));
				 beanUrl.setUrlReveal(rsSelect.getString(4));
				 beanUrl.setPassword(rsSelect.getString(5));
				 beanUrl.setKeyShort(rsSelect.getString(6));
				
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

	public static ArrayList<beanUrl> getAllUrlById(long id) {
		try {
			java.sql.Connection	conn= initDB();
			
		
			
			java.sql.PreparedStatement selectUrlsById = conn.prepareStatement("SELECT * FROM url WHERE user_id = ?");
			selectUrlsById.setLong(1, id);
		
			
			ResultSet rsSelect = selectUrlsById.executeQuery();
		
			
			ArrayList<beanUrl> listUrl = new ArrayList<beanUrl>();
			
			while(rsSelect.next()) {
				 beanUrl beanUrl = new beanUrl();
				 beanUrl.setUrl(rsSelect.getString(2));
				 beanUrl.setUrlShort(rsSelect.getString(3));
				 beanUrl.setUrlReveal(rsSelect.getString(4));
				 beanUrl.setPassword(rsSelect.getString(5));
				 beanUrl.setKeyShort(rsSelect.getString(6));
				 java.util.Date newDate = new Date(rsSelect.getDate("created").getTime());
				 beanUrl.setCreated(newDate);
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
	
	public static beanUrl get(String id) {
		try {
			java.sql.Connection	conn= initDB();
			java.sql.PreparedStatement getOneUrl = conn.prepareStatement("SELECT * FROM url WHERE keyShort = ?;");
			getOneUrl.setString(1,id); 
			
			ResultSet url = getOneUrl.executeQuery();
			
			if(url.next()) {
				
				beanUrl newUrl = new beanUrl();
				newUrl.setUrl(url.getString(2));
				newUrl.setUrlShort(url.getString(3));
				newUrl.setPassword(url.getString(5));
				newUrl.setCaptcha(url.getBoolean(9));
				newUrl.setMinDate(url.getDate(10));
				newUrl.setMaxDate(url.getDate(11));
				newUrl.setMaxClick(url.getInt(12));
				db.close(conn);
				return newUrl;
			}else {
				db.close(conn);
				return null;
			}
			
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		return null;
	}
	
}
