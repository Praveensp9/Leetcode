package leetcode;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class DailyCodingProblem_55 {
	
	private static final Map<String,String> map = new HashMap<>();
	private static int length = 6;
	private static Random random = new Random();
	
	private static String shorten(String longUrl) {
		String shorturl="";
		int cnt=0;
		
		// This loop is to ensure there are no duplicates in the Map
		// containing the URL
		do {
			shorturl = getRandomString(length);
		}while(map.containsKey(shorturl));
		
		map.put(shorturl, longUrl);
		return shorturl;
	}
	
	private static String restoreUrl(String shorturl) {
		return map.get(shorturl);
	}
	
	private static String getRandomString(int length) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<length;i++) {
			boolean bool =  random.nextBoolean();
			if(bool) {
				sb.append(random.nextInt(10));
			}
			else {
				char ch = random.nextBoolean() ? 'A' : 'a';
				ch += random.nextInt(26);
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	private static String ImplementURLSortner() {
		
		String url = "https://www.praveen9.com/";
		String shortUrl = shorten(url);
		
		return shortUrl;
	}

	public static void main(String[] args) {
		String encrypted = ImplementURLSortner();
		System.out.println(encrypted);
		
		String longUrl = restoreUrl(encrypted);
		System.out.println(longUrl);
	}

}
