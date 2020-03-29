import java.util.*;
import java.io.*;

public class boj16932 {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int max = -1;
	//static int[] group = new int[1000000];
	static List <Integer> group = new ArrayList<Integer>();
	static int count;

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
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		check = new boolean[N][M];
		int color = 1;

// 사전 작업 bfs를 돌면서 컬러링 해주는 작업...
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (map[y][x] == 1 && check[y][x] == false) {
					count = 0;
					bfs(new Point(y, x), color);
					group.add(count);
					color++;
				}
			}
		}

//		0에서 4방 탐색..
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (map[y][x] == 0) {
					Set<Integer> set = new HashSet<Integer>();
					int sum = 0;
					
					for(int i=0; i<4; i++) {
						int ny = y + dy[i];
						int nx = x + dx[i];
						
						if (nx < 0 || ny < 0 || nx > M - 1 || ny > N - 1) {
							continue;
						}

						if (map[ny][nx] == 0) {
							continue;
						}
						
						if(set.contains(map[ny][nx])) {
							continue;
						}
						
						set.add(map[ny][nx]);
						sum += group.get(map[ny][nx]-1);
					}
					
					sum += 1;
					
					if(sum > max) {
						max = sum;
					}
					
				}

			}
		}
		
		System.out.println(max);

	}

// bfs 하면서 컬러링....	
	static void bfs(Point p, int color) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(p);
		check[p.y][p.x] = true;
		map[p.y][p.x] = color;

		while (!queue.isEmpty()) {
			Point temp = queue.poll();
			int y = temp.y;
			int x = temp.x;
			count++;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (nx < 0 || ny < 0 || nx > M - 1 || ny > N - 1) {
					continue;
				}

				if (map[ny][nx] == 0) {
					continue;
				}

				if (check[ny][nx] == true) {
					continue;
				}

				queue.offer(new Point(ny, nx));
				check[ny][nx] = true;
				map[ny][nx] = color;
			}
		}
	}
}
