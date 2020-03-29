import java.io.*;
import java.util.*;

public class swea1952 {
	static int count; // 이용계획 배열에 0이아닌 숫자가 몇개있는지...
	static int[] month = new int[12];
	static int[] price = new int[4];
	static int result;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}

			go(1, 0);

			if (min > price[3]) {
				min = price[3];
			}

			System.out.println("#" + tc +" "+ min);
		}
		// 입력 다 받음.
	}

	static void go(int cnt, int start) {
		if (cnt > 12) {
			if (min > result) {
				min = result;
			}
			return;
		}

		if (month[start] == 0) {
			go(cnt + 1, start + 1);
		}

		for (int j = 0; j < 3; j++) {
			if (j == 0) {
				result += month[start] * price[j];
				go(cnt + 1, start + 1);
				result -= month[start] * price[j];
			}

			else if (j == 1) {
				result += price[j];
				go(cnt + 1, start + 1);
				result -= price[j];
			}

			else {
				result += price[j];
				go(cnt + 3, start + 3);
				result -= price[j];
			}
		}
	}
}
