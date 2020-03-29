import java.util.Scanner;

public class boj14620 {
	static int N;
	static int[][] price;
	static boolean[][] check;
	static int min = Integer.MAX_VALUE;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		price = new int[N][N];
		check = new boolean[N][N];
		System.out.println();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				price[i][j] = sc.nextInt();
			}
		}

		go(0);

		System.out.println(min);
	}

	static void go(int cnt) {
		// 종료조건
		if (cnt == 3) {
			int sum = 0;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (check[y][x] == true) {
						sum += price[y][x];
					}
				}
			}

			if (min > sum)
				min = sum;
			
			return;
		}
		
		int sum = 0;
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (check[y][x] == true) {
					sum += price[y][x];
				}
			}
		}

		if (min < sum) {
			return;
		}
			
		// 재귀 & 실행

//		1. start_x, start_y 좌표부터 4방탐색후 ok 사인 나오면 꽃을 심는다.
//		2. 재귀를 탄다.
//		3. 재귀가 끝나면 다시 꽃을 뽑는다.
		

		// plant(start_x, start_y);

		for (int y = 1; y < N-1; y++) {
			for (int x = 1; x < N-1; x++) {
				boolean flag = false;

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (check[ny][nx] == true) {
						flag = true;
						break;
					}
				}

				if (flag == true)
					continue;

				plant(x, y);
				go(cnt + 1);
				unplant(x, y);

			}
		}
	}

	static void plant(int x, int y) {
		check[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			check[ny][nx] = true;
		}
	}

	static void unplant(int x, int y) {
		check[y][x] = false;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			check[ny][nx] = false;
		}
	}
}
