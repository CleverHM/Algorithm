import java.io.*;
import java.util.*;

public class boj2178 {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static class Point{
		int y;
		int x;
		int distance;
		public Point(int y, int x, int distance) {
			this.y = y;
			this.x = x;
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		check = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		
		bfs(new Point(0,0,1));
	}
	
	static void bfs(Point p){
		Queue<Point> queue = new LinkedList<>();
		queue.offer(p);
		check[p.y][p.x] = true;
		
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			int y = temp.y;
			int x = temp.x;
			int distance = temp.distance;
			
			if((y == n-1) && (x == m-1)) {
				System.out.println(distance);
				break;
			}
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
					continue;
				}
				
				if(map[ny][nx] == 0) {
					continue;
				}
				
				if(check[ny][nx] == true) {
					continue;
				}
				
				check[ny][nx] = true;
				queue.offer(new Point(ny,nx,distance+1));
			}
		}
	}
}
