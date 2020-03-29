import java.io.*;
import java.util.*;

public class boj14225 {
	static int N;
	static int[] arr;
	static boolean[] check = new boolean[2000001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		go(0,0);
		
		for(int i=1; i<2000001; i++) {
			if(check[i] == false) {
				System.out.println(i);
				break;
			}
		}
	}
	
	static void go(int level, int sum) {
		if(level == arr.length) {
			if(sum != 0) {
				check[sum] = true;
			}
			return;
		}
		
		go(level+1, sum+arr[level]);
		go(level+1, sum);
	}
}
