import java.util.*;
import java.io.*;

public class boj6321 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=n; i++) {
			char[] s1 = br.readLine().toCharArray();
			
			for(int j=0; j<s1.length; j++) {
				if(s1[j] == 'Z') {
					s1[j] = 'A';
				}
				else {
					s1[j] = (char)(s1[j] + 1);
				}
			}
			
			System.out.println("String #" + i);
			System.out.println(String.valueOf(s1));
			System.out.println();
		}
		
	}
}
