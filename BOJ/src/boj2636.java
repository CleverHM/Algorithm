import java.io.*;
import java.util.*;

public class boj2636 {
	static int R; // 세로 길이
	static int C; // 가로 길이
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] check;

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int time = 0;
		int slice = 0;

		for (int y = 0; y < R; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < C; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			check = new boolean[R][C];

			out: for (int y = 0; y < R; y++) {
				for (int x = 0; x < C; x++) {
					if (map[y][x] == 0) {
						boolean flag = false;

						for (int i = 0; i < 4; i++) {
							int ny = y + dy[i];
							int nx = x + dx[i];

							if (ny < 0 || nx < 0 || ny > R - 1 || nx > C - 1) {
								continue;
							}

							if (map[ny][nx] == 1) {
								flag = true;
								break;
							}
						}

						if (flag == false && check[y][x] == false) {
							bfs(new Point(y, x));
							break out;
						}
					}
				}
			}
			
			int count = 0;

			for (int y = 0; y < R; y++) {
				for (int x = 0; x < C; x++) {
					if (map[y][x] == 1) {
						for (int i = 0; i < 4; i++) {
							int ny = y + dy[i];
							int nx = x + dx[i];

							// 범위 벗어난 경우...
							if (ny < 0 || nx < 0 || ny > R - 1 || nx > C - 1) {
								continue;
							}

							// 공기 중에 노출되었다는것....
							if (map[ny][nx] == -1) {
								map[y][x] = 0;
								count++;
								break;
							}
						}
					}
				}
			}
			
			slice = count;

			count = 0;

			for (int y = 0; y < R; y++) {
				for (int x = 0; x < C; x++) {
					if (map[y][x] == 1) {
						count++; // 치즈 덩어리 개수
					}
				}
			}

			time++;

			if (count == 0) {
				break;
			}
		}

		System.out.println(time);
		System.out.println(slice);
	}

	static void bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		check[start.y][start.x] = true;
		map[start.y][start.x] = -1;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				// 범위 벗어난 경우...
				if (ny < 0 || nx < 0 || ny > R - 1 || nx > C - 1) {
					continue;
				}

				if (map[ny][nx] == 1) {
					continue;
				}

				// 이미 -1로 칠해진경우.
				if (check[ny][nx] == true) {
					continue;
				}

				check[ny][nx] = true;
				map[ny][nx] = -1;
				queue.offer(new Point(ny, nx));
			}

		}
	}
}
