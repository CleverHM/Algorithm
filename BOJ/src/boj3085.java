import java.io.*;
import java.util.*;

public class boj3085 {
	static int N;
	static char[][] map;
	static int max = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
//  	입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

//		검사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {

				char temp = map[i][j];
				map[i][j] = map[i][j + 1];
				map[i][j + 1] = temp;

				// 검사하는 부분...
				check();

				temp = map[i][j];
				map[i][j] = map[i][j + 1];
				map[i][j + 1] = temp;

			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {

				char temp = map[j][i];
				map[j][i] = map[j+1][i];
				map[j+1][i] = temp; 

				// 검사하는 부분...
				check();

				temp = map[j][i];
				map[j][i] = map[j+1][i];
				map[j+1][i] = temp; 

			}
		}
		
		
//		출력
		System.out.println(max);
	}



	static void check() {
		for (int i = 0; i < N; i++) {
			char form = map[i][0];
			int cnt = 1;

			for (int j = 1; j < N; j++) {
				if (form != map[i][j]) {
					form = map[i][j];
					max = Math.max(max, cnt);
					cnt = 1;
					continue;
				}

				cnt++;
			}

			max = Math.max(max, cnt);
		}

		for (int j = 0; j < N; j++) {
			char form = map[0][j];
			int cnt = 1;

			for (int i = 1; i < N; i++) {
				if (form != map[i][j]) {
					form = map[i][j];
					max = Math.max(max, cnt);
					cnt = 1;
					continue;
				}
				cnt++;
			}

			max = Math.max(max, cnt);
		}
	}
}
