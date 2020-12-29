package networkExam1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlClassExam {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://news.hankooki.com");
			System.out.println(url.getAuthority());
			System.out.println(url.getQuery());
			System.out.println(url.getContent());
		
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
