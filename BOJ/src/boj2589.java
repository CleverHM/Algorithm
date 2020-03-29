import java.util.*;
import java.io.*;

public class boj2589 {
	static char[][] map;
	static boolean[][] check;
	static boolean[][] a_check;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int c;
	static int r;
	static int max = -1;
	static int time = 0;
	
	static class Point{
		int y;
		int x;
		int seconds;
		public Point(int y, int x, int seconds) {
			this.y = y;
			this.x = x;
			this.seconds = seconds;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();//세로 길이
		c = sc.nextInt();//가로 길이
		map = new char[r][c];//맵
		sc.nextLine();
		
		for(int i=0; i<r; i++) {
			char[] st = sc.nextLine().toCharArray();
			for(int j=0; j<c; j++) {
				map[i][j] = st[j];
			}
		}
		
		a_check = new boolean[r][c];
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(a_check[i][j] == false && map[i][j] == 'L') {
					check = new boolean[r][c];
					bfs(new Point(i,j,0));
					a_check[i][j] = true;
					if(time > max) {
						max = time;
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	static void bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		check[start.y][start.x] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int y = p.y;
			int x = p.x;
			int seconds = p.seconds;
			if(time < seconds)
				time = seconds;
			
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx < 0 || ny < 0 || nx > c-1 || ny > r-1) {
					continue;
				}
				
				if(check[ny][nx] == true || map[ny][nx] == 'W') {
					continue;
				}
				
				check[ny][nx] = true;
				queue.offer(new Point(ny,nx,seconds+1));
			}
		}
	}
}
