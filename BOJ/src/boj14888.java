import java.io.*;
import java.util.*;

public class boj14888 {
	static int N;
	static int[][] TP;
	static int max = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		TP = new int[N+1][2];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			TP[i][0] = Integer.parseInt(st.nextToken());
			TP[i][1] = Integer.parseInt(st.nextToken());
		}
		
		go(1,0);
		
		System.out.println(max);
	}
	
	static void go(int idx, int profit) {
		if(idx > N) {
			if(profit > max) {
				max = profit;
			}
			return;
		}
	
		if(idx + TP[idx][0] > N+1) {
			go(idx+1, profit);
		}
		
		else {
			go(idx + TP[idx][0], profit + TP[idx][1]);
			go(idx+1, profit);
		}
		
	}
	
}
