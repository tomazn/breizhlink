package urlShortener;

import java.util.HashMap;
import java.util.Random;

/*
 * URL Shortener
 */
public class urlShortener {
	// storage for generated keys
	private HashMap<String, String> keyMap; // key-url map
	private HashMap<String, String> valueMap;// url-key map to quickly check
												// whether an url is
	// already entered in our system
	private String domain; // Use this attribute to generate urls for a custom
							// domain name defaults to http://fkt.in
	private char myChars[]; // This array is used for character to number
							// mapping
	private Random myRand; // Random object used to generate random integers
	private int keyLength; // the key length in URL defaults to 8

	// Default Constructor
	urlShortener() {
		keyMap = new HashMap<String, String>();
		valueMap = new HashMap<String, String>();
		myRand = new Random();
		keyLength = 8;
		myChars = new char[62];
		for (int i = 0; i < 62; i++) {
			int j = 0;
			if (i < 10) {
				j = i + 48;
			} else if (i > 9 && i <= 35) {
				j = i + 55;
			} else {
				j = i + 61;
			}
			myChars[i] = (char) j;
		}
		domain = "";
	}

	// Constructor which enables you to define tiny URL key length and base URL
	// name
	public urlShortener(int length, String newDomain) {
		this();
		this.keyLength = length;
		if (!newDomain.isEmpty()) {
			domain = newDomain;
		}
	}

	// shortenURL
	// the public method which can be called to shorten a given URL
	public String shortenURL(String longURL) {
		String shortURL = "";
			if (valueMap.containsKey(longURL)) {
				shortURL = domain + "/" + valueMap.get(longURL);
			} else {
				String key =  getKey(longURL);
				shortURL = domain + "/" + key;
			}
		// add http part
		return shortURL;
	}

	// expandURL
	// public method which returns back the original URL given the shortened url
	public String expandURL(String shortURL) {
		String longURL = "";
		String key = shortURL.substring(domain.length() + 1);
		longURL = keyMap.get(key);
		return longURL;
	}


	/*
	 * Get Key method
	 */
	private String getKey(String longURL) {
		String key;
		key = generateKey();
		keyMap.put(key, longURL);
		valueMap.put(longURL, key);
		return key;
	}

	// generateKey
	private String generateKey() {
		String key = "";
		boolean flag = true;
		while (flag) {
			key = "";
			for (int i = 0; i <= keyLength; i++) {
				key += myChars[myRand.nextInt(62)];
			}
			// System.out.println("Iteration: "+ counter + "Key: "+ key);
			if (!keyMap.containsKey(key)) {
				flag = false;
			}
		}
		return key;
	}
}