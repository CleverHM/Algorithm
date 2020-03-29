import java.io.*;
import java.util.*;

public class boj2206 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] check;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static int ans = -1;
	
	
	
	static class Point{
		int y;
		int x;
		int distance;
		int drill;
		
		public Point(int y, int x, int distance, int drill) {
			this.y = y;
			this.x = x;
			this.distance = distance;
			this.drill = drill;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new int[N][M];
		
		for(int y=0; y<N; y++) {
			String str = br.readLine();
			for(int x=0; x<M; x++) {
				map[y][x] = Integer.parseInt(str.charAt(x)+"");
				check[y][x] = Integer.MAX_VALUE;
			}
		}
		
		bfs(new Point(0,0,1,0));
		
		System.out.println(ans);
		
	}
	
	static void bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		check[start.y][start.x] = 0; 
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int y = p.y;
			int x = p.x;
			int dist = p.distance;
			int drill = p.drill;
			
			if((y == N-1) && (x == M-1)) {
				ans = dist;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny < 0 || nx < 0 || ny > N-1 || nx > M-1) {
					continue;
				}
				
				if(check[ny][nx] <= drill) {
					continue;
				}
				
				if(map[ny][nx] == 0) {
					check[ny][nx] = drill;
					Point temp = new Point(ny,nx,dist+1,drill);
					queue.offer(temp);
				}
				
				else {
					if(drill == 0) {
						check[ny][nx] = drill+1;
						Point temp = new Point(ny,nx,dist+1,drill+1);
						queue.offer(temp);
					}
				}	
				
			}
		
		}
		
	}
}
