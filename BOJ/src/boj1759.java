import java.io.*;
import java.util.*;

public class boj1759 {
	static int L;
	static int C;
	static char[] arr;
	static char[] result;
	static String[] str;
	static int idx;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		result = new char[L];
		str = new String[2000];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		go(0,0);
		
		Arrays.sort(str,0,idx);
		
		for(int i=0; i<idx; i++) {
			System.out.println(str[i]);
		}
		
	}
	
	static void go(int cnt, int start) {
		if(cnt == L) {
			int cnt1 = 0; //모음갯수 세는것.
			int cnt2 = 0; //자음갯수 세는것.
			char[] copy = new char[L];
			
			for(int i=0; i<L; i++) {
				if(result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
					cnt1++;
				}
				else {
					cnt2++;
				}
			}
			
			if(cnt1 < 1 || cnt2 < 2) {
				return;
			}
			
			else {
				
				for(int i=0; i<L; i++) {
					copy[i] = result[i];
				}
				
				Arrays.sort(copy);
				str[idx] = String.copyValueOf(copy);
				idx++;
				return;
			}
		}
		
		for(int i=start; i<C; i++) {
			result[cnt] = arr[i];
			go(cnt+1, i+1);
		}
	}
}
