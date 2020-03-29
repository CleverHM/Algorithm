import java.io.*;
import java.util.*;

public class boj3055 {
	static int R;
	static int C;
	static char[][] map;
	static Queue<Point> water;
	static boolean[][] wc;
	static Queue<Point> bieber;
	static boolean[][] bc;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

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
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		wc = new boolean[R][C];
		bc = new boolean[R][C];
		water = new LinkedList<>();
		bieber = new LinkedList<>();

		for (int y = 0; y < R; y++) {
			char[] ch = br.readLine().toCharArray();
			for (int x = 0; x < C; x++) {
				map[y][x] = ch[x];
				// 물의 초기 좌표 큐에 넣어줌
				if (map[y][x] == '*') {
					water.offer(new Point(y,x,0));
					wc[y][x] = true;
				}
				// 비버의 초기 좌표 큐에 넣어줌
				if (map[y][x] == 'S') {
					bieber.offer(new Point(y,x,0));
					bc[y][x] = true;
				}
			}
		}
		// 입력 다 받음...
		
		int result = bfs();
		
		if(result == -1) {
			System.out.println("KAKTUS");
		}
		else {
			System.out.println(result);
		}

	}
	
	static int bfs() {
		int seconds = 0;
		
		out : while((!water.isEmpty()) || (!bieber.isEmpty())) {
			// 먼저 물을 퍼뜨린다...
			while((!water.isEmpty()) && (water.peek().time == seconds)) {
				Point p = water.poll();
				int y = p.y;
				int x = p.x;
				int time = p.time;
				
				for(int i=0; i<4; i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny < 0 || nx < 0 || ny > R-1 || nx > C-1) {
						continue;
					}
					
					if(wc[ny][nx] == true) {
						continue;
					}
					
					if(map[ny][nx] == 'X' || map[ny][nx] == 'D') {
						continue;
					}
					
					if(map[ny][nx] == '.') {
						map[ny][nx] = '*';
						wc[ny][nx] = true;
						water.offer(new Point(ny,nx,time+1));
					}
				}
			}
			
			boolean flag = false;
			
			while((!bieber.isEmpty()) && (bieber.peek().time == seconds)) {
				Point p = bieber.poll();
				int y = p.y;
				int x = p.x;
				int time = p.time;
				
				if(map[y][x] == 'D') {
					return time;
				}
				
				for(int i=0; i<4; i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny < 0 || nx < 0 || ny > R-1 || nx > C-1) {
						continue;
					}
					
					if(bc[ny][nx] == true) {
						continue;
					}
					
					if(map[ny][nx] == 'X' || map[ny][nx] == '*') {
						continue;
					}
								
					bc[ny][nx] = true;
					bieber.offer(new Point(ny,nx,time+1));
				}
			}
			
			seconds++;
		}
		
		return -1;
	}
	
	
}
