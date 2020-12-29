package networkExam1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddrExam {

	public static void main(String[] args) {
		
		// ip주소를 다루기 위한 메서드
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		
		
		// 네이버 주소
		
		try {
			// 도메인명을 통해서 ip주소를 얻어낼 수 있다.
			ip = InetAddress.getByName("www.naver.com");
			
			System.out.println(ip.getHostName());// 도메인명, www.naver.com
			System.out.println(ip.getHostAddress());// ip주소를 문자열로 반환, 223.130.195.95
			System.out.println(ip.toString()); // www.naver.com/223.130.195.95
			
			
			byte[] ipAddr = ip.getAddress(); // ip주소를 바이트배열로 반환
			System.out.println(Arrays.toString(ipAddr)); // [-33, -126, -61, 95], 바이트를 넘어간 표현은 음수
			
			
			String result = "";
			
			for (int i = 0; i < ipAddr.length; i++) {
				result += (ipAddr[i]<0?ipAddr[i]+256:ipAddr[i])+".";
			}			
			System.out.println(result);
			// 223.130.195.95.
			int n = result.lastIndexOf(".");
			String results = result.substring(0, n);
			System.out.println(results);
			// 223.130.195.95
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		}
		
		// 내 기기 (호스트)
		
		try {
			ip = InetAddress.getLocalHost(); // 내 기기의 주소
			System.out.println(ip.getHostName()); // DESKTOP-320BQ9H
			System.out.println(ip.getHostAddress()); // 기기의 ip주소, 192.168.1.2
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		
		try {
			// 도메인명에 맵핑된 모든 ip주소들을 가져옴.
			ipArr = InetAddress.getAllByName("www.naver.com");
			
			for (int i = 0; i < ipArr.length; i++) {
				System.out.println(ipArr[i]);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		

	}

}
