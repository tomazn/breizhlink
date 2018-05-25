package beanUrl;

public class beanUrl {
	private String url;
	private String urlShort;
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

	private String urlReveal;
	
	public beanUrl() {
		this.url = "";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
