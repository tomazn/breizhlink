package beanUrl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAObeanUrl;

public class beanUrl {
	private String url;
	private String urlShort;
	private String urlReveal;
	
	public beanUrl() {
		this.url = "";
		this.urlShort = "";
		this.urlReveal = "";
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
	
	public void save() throws SQLException {
		DAObeanUrl.save(this);
	}
	
	public static ArrayList<beanUrl> getAllUrl() throws SQLException {
		return DAObeanUrl.getAllUrl();
		
	}
	
}
