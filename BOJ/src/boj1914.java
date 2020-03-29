import java.io.*;
import java.util.*;

public class boj1914 {

	static StringBuilder result = new StringBuilder();
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[] = new int[N+1];
		dp[1] = 1;
		
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1]*2 + 1;
		}
		
		
		System.out.println(dp[N]);
		
		if(N < 20) {
			hanoi(N,1,2,3);
			System.out.println(result);
		}
	}

	// 몇개의 원판을 움직일것인가 == 맨아래원판번호(cnt), 시작기둥, 임시기둥, 목적기둥
	static void hanoi(int cnt, int from, int temp, int to) {
		if(cnt == 0) return;
		hanoi(cnt-1, from, to, temp);
		//System.out.println(from +" " + to);
		result.append(from + " " + to + "\n");
		hanoi(cnt-1, temp, from, to);
	}
}
