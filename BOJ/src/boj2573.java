import java.util.*;
import java.io.*;

public class boj2573 {
	static int N;
	static int M;
	static int[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static boolean[][] check;

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 행의 갯수
		M = Integer.parseInt(st.nextToken());// 열의 갯수
		map = new int[N][M];
		int year = 0;

		// 맵 초기화...
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			// step1. 배열을 순회하면서 높이가 0이 아닌 지점에 대해서, 사방탐색하고 주변의 0의 갯수만큼 높이를 감소시킨다..
			int[][] copyMap = new int[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copyMap[i][j] != 0) {
						for (int k = 0; k < 4; k++) {
							int ni = i + di[k];
							int nj = j + dj[k];

							if (ni < 0 || nj < 0 || ni > N - 1 || nj > M - 1) {
								continue;
							}

							if (copyMap[ni][nj] != 0) {
								continue;
							}

							if (map[i][j] != 0) {
								map[i][j] -= 1;
							}

						}
					}
				}
			}

			year++;

			check = new boolean[N][M];
			int cnt = 0; // bfs 호출횟수...

			// step2. 배열을 순회하면서 아직 방문하지 않았으면서 && 높이가 0이라면 해당지점에서 bfs한다.(bfs 호출횟수가 덩어리갯수)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (check[i][j] == false && map[i][j] != 0) {
						bfs(new Point(i, j));
						cnt++;
					}
				}
			}

			if (cnt >= 2) {
				System.out.println(year);
				break;
			}

			else if (cnt == 0) {
				System.out.println(0);
				break;
			}
		}
	}

	static void bfs(Point p) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(p);
		check[p.i][p.j] = true;

		while (!queue.isEmpty()) {
			Point temp = queue.poll();
			int i = temp.i;
			int j = temp.j;

			for (int k = 0; k < 4; k++) {
				int ni = i + di[k];
				int nj = j + dj[k];

				if (ni < 0 || nj < 0 || ni > N - 1 || nj > M - 1) {
					continue;
				}

				if (map[ni][nj] == 0) {
					continue;
				}

				if (check[ni][nj] == true) {
					continue;
				}

				queue.offer(new Point(ni, nj));
				check[ni][nj] = true;
			}
		}
	}
}
