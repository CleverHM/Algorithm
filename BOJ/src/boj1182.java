import java.io.*;
import java.util.*;


public class boj1182 {
	static int N;
	static int S;
	static int arr[];
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		go(0, 0);
		
		if(S == 0) {
			System.out.println(count-1);
		}
		
		else {
			System.out.println(count);
		}
	}
	
	static void go(int idx, int sum) {
		
		if(idx == arr.length) {
			
			if(sum == S) {
				count++;
			}
			
			return;
		}
		
		go(idx+1, sum+arr[idx]);
		
		go(idx+1, sum);
	}
}
