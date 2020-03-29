import java.io.*;
import java.util.*;

public class swea7793 {
	static int R;
	static int C;
	static char[][] map;
	static Queue<Point> devil;
	static boolean[][] dc;
	static Queue<Point> suyeon;
	static boolean[][] bc;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Point {
		int y;
		int x;
		int time;

		public Point(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			dc = new boolean[R][C];
			bc = new boolean[R][C];
			devil = new LinkedList<>();
			suyeon = new LinkedList<>();

			for (int y = 0; y < R; y++) {
				char[] ch = br.readLine().toCharArray();
				for (int x = 0; x < C; x++) {
					map[y][x] = ch[x];
					// 악마의 초기 좌표 큐에 넣어줌
					if (map[y][x] == '*') {
						devil.offer(new Point(y, x, 0));
						dc[y][x] = true;
					}
					// 수연이의 초기 좌표 큐에 넣어줌
					if (map[y][x] == 'S') {
						suyeon.offer(new Point(y, x, 0));
						bc[y][x] = true;
					}
				}
			}
			// 입력 다 받음...

			int result = bfs();

			if (result == -1) {
				System.out.println("#" + tc +" "+"GAME OVER");
			} else {
				System.out.println("#" + tc +" "+result);
			}
		}

	}

	static int bfs() {
		int seconds = 0;

		out: while ((!devil.isEmpty()) || (!suyeon.isEmpty())) {
			// 먼저 악마를 퍼뜨린다...
			while ((!devil.isEmpty()) && (devil.peek().time == seconds)) {
				Point p = devil.poll();
				int y = p.y;
				int x = p.x;
				int time = p.time;

				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];

					if (ny < 0 || nx < 0 || ny > R - 1 || nx > C - 1) {
						continue;
					}

					if (dc[ny][nx] == true) {
						continue;
					}

					if (map[ny][nx] == 'X' || map[ny][nx] == 'D') {
						continue;
					}

					if (map[ny][nx] == '.') {
						map[ny][nx] = '*';
						dc[ny][nx] = true;
						devil.offer(new Point(ny, nx, time + 1));
					}
				}
			}

			boolean flag = false;

			while ((!suyeon.isEmpty()) && (suyeon.peek().time == seconds)) {
				Point p = suyeon.poll();
				int y = p.y;
				int x = p.x;
				int time = p.time;

				if (map[y][x] == 'D') {
					return time;
				}

				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];

					if (ny < 0 || nx < 0 || ny > R - 1 || nx > C - 1) {
						continue;
					}

					if (bc[ny][nx] == true) {
						continue;
					}

					if (map[ny][nx] == 'X' || map[ny][nx] == '*') {
						continue;
					}

					bc[ny][nx] = true;
					suyeon.offer(new Point(ny, nx, time + 1));
				}
			}

			seconds++;
		}

		return -1;
	}

}
