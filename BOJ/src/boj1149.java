import java.io.*;
import java.util.*;


public class boj1149 {
	static int N; // 집의 수.
	static int[][] home;
	static int[] price;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		home = new int[N][3];
		price = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go(0,-1,0);
		
		System.out.println(min);
	}
	
	static void go(int level, int sel, int idx) {
		if(level == N) {
			int sum = 0;
			
			for(int i=0; i<N; i++) {
				sum += price[i];
			}
			
			if(sum < min) {
				min = sum;
			}
			
			return;
		}
		
		for(int i=0; i<3; i++) {
			if(i == sel)
				continue;
			price[idx] = home[level][i];
			go(level+1,i,idx+1);
		}
	}
}
