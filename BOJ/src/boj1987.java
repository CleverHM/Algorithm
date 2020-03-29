import java.util.*;
import java.io.*;

public class boj1987 {
	static int r;
	static int c;
	static char[][] map;
	static boolean[] check;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int count;
	static int mx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			r = Integer.parseInt(stk.nextToken());
			c = Integer.parseInt(stk.nextToken());
			map = new char[r+1][c+1];
			
			for(int i=1; i<=r; i++) {
				String str = br.readLine();
				for(int j=1; j<=c; j++) {
					map[i][j] = str.charAt(j-1);
				}
			}
			
			mx = -1;
			check = new boolean[30];
			count = 0;
			
			go(1,1);
			
			System.out.println("#" + tc +" "+mx);
		}
		
	}
	
	static void go(int y, int x) {
		char ch = map[y][x];
		check[ch - 'A'] = true;
		count++;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx < 1 || ny < 1 || nx > c || ny > r) {
				continue;
			}
			
			if(check[map[ny][nx] - 'A'] == true)
				continue;
			
			go(ny, nx);
			count--;
			check[map[ny][nx] - 'A'] = false;
		}
		
		if(mx < count)
			mx = count;
	}
}
