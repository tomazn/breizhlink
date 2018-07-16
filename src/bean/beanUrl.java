package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dao.DAObeanUrl;

public class beanUrl {
	private String url;
	private String urlShort;
	private String urlReveal;
	private String password;
	private String keyShort;
	private Date created;
	
	public beanUrl() {
		this.url = "";
		this.urlShort = "";
		this.urlReveal = "";
		this.password = "";
		this.keyShort = "";
		this.created = new Date();
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public String getKeyShort() {
		return keyShort;
	}


	public void setKeyShort(String keyShort) {
		this.keyShort = keyShort;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUrlShort() {
		return urlShort;
	}

	public void setUrlShort(String urlShort) {
		this.urlShort = urlShort;
	}

	public String getUrlReveal() {
		return urlReveal;
	}

	public void setUrlReveal(String urlReveal) {
		this.urlReveal = urlReveal;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void save(Integer id) throws SQLException {
		DAObeanUrl.save(this, id);
	}
	
	public static ArrayList<beanUrl> getAllUrl() throws SQLException {
		return DAObeanUrl.getAllUrl();
	}
	
	public static ArrayList<beanUrl> getAllUrlById(long id) throws SQLException {
		return DAObeanUrl.getAllUrlById(id);
	}
	
	public static beanUrl getOne(String id) throws SQLException {
		return DAObeanUrl.get(id);
	}
	
}
