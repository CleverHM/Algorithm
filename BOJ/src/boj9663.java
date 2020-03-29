import java.util.*;
import java.io.*;

public class boj9663 {
	static int N;
	static int[] map;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N];
		go(0);
		System.out.println(count);
	}

	static void go(int level) {
		if (level == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			map[level] = i;
			if (isPromising(level)) {
				go(level + 1);
			}
		}
	}

	static boolean isPromising(int level) {
		// 위쪽 방향 체크(열 인덱스가 같은애들 체크)
		for (int i = level - 1; i >= 0; i--) {
			if (map[i] == map[level])
				return false;
		}
		
		// 왼쪽 위 대각선 체크
		for (int i = level - 1; i >= 0; i--) {
			if (i - map[i] == level - map[level])
				return false;
		}

		// 오른쪽 위 대각선 체크
		for (int i = level - 1; i >= 0; i--) {
			if (i + map[i] == level + map[level])
				return false;
		}

		return true;
	}
}
