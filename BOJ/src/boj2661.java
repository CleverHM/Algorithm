import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2661 {
	
	static int N;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		go(1, "1");
	}

	private static void go(int len, String string) {
		
		if(len == N) {
			flag = true;
			System.out.println(string);
			return;
		}
		
		for(int i=1; i<=3; i++) {
			String s = string+i;
			if(check(s) == true) {
				go(len+1,s);
			}
			
			if(flag == true) {
				return;
			}
		}
	}

	private static boolean check(String s) {
		int len = s.length();
		int end = len;
		int start = len -1;
		
		for(int i=1; i<=len/2; i++) {
			if(s.substring(start-i, end-i).equals(s.substring(start,end))) {
				return false;
			}
			
			start -= 1;
		}
		return true;
	}
}
