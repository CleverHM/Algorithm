import java.io.*;
import java.util.*;


public class boj9095 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=4; i<=11; i++) {
			int sum = 0;
			
			for(int j=i-3; j<i; j++) {
				sum += dp[j];
			}
			
			dp[i] = sum; 
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			int idx = Integer.parseInt(br.readLine());
			System.out.println(dp[idx]);
		}
	}
}
