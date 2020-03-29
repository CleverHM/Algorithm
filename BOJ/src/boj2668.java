import java.io.*;
import java.util.*;

public class boj2668 {
	static int N;
	static int[] arr;
	static boolean[] check;
	static Set<Integer> set1 = new TreeSet<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1; i<=N; i++) {
			go(i, i, 0);
		}

		System.out.println(set1.size());
		
		for(int num : set1) {
			System.out.println(num);
		}
		
	}

	static void go(int start, int end, int cnt) {
				
		if(arr[start] == end) {
			set1.add(start);
			return;
		}
		
		if(cnt == N) {
			return;
		}
		
		go(arr[start], end, cnt+1);
	}
}
