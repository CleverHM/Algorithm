import java.io.*;
import java.util.*;


public class boj2210 {
	static int[][] map;
	static int[] result;
	static boolean[][] v;
	static boolean[] check = new boolean[1000000];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		
		StringTokenizer st;
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				v = new boolean[5][5];
				result = new int[6];
				result[0] = map[i][j];
				go(1,i,j);
			}
		}
		
		System.out.print(count);
	}
	
	
	static void go(int cnt, int y, int x) {
		
		if(cnt == 6) {
			int sum = result[0] * 100000 + result[1] * 10000 
					+ result[2] * 1000 + result[3] * 100 + result[4] * 10 + result[5];
			
			if(check[sum] == false) {
				check[sum] = true;
				count++;
			}
			
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
				continue;
			}
			
			result[cnt] = map[ny][nx];
			go(cnt+1, ny, nx);
		}
	}
}
