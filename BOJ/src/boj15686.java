import java.io.*;
import java.util.*;

public class boj15686 {
	static int N;
	static int M;
	static int[][] map;
	static Point[] chicken;
	static int num_c; // 치킨집 숫자.
	static boolean[] check;
	static Point[] home;
	static int num_h; // 집의 숫자.
	static Point[] result;
	static int ans;
	
	static class Point{
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
		map = new int[N][N];
		chicken = new Point[13];
		home = new Point[2*N];
		
		
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if(map[y][x] == 1) {
					home[num_h++] = new Point(y,x);
				}
				else if(map[y][x] == 2) {
					chicken[num_c++] = new Point(y,x);
				}
			}
		}
		
		for(int i=1; i<=M; i++) {
			// 최대 num_c개의 치킨집 중에서 1개를 선택하는 경우, 
			// 2개를 선택하는 경우, 3개를 선택하는 경우....최대 M개를 선택하는 경우.
			result = new Point[i];
			ans = Integer.MAX_VALUE;
			select(0, i, 0);
		}
		// 입력 다 받음...
		
		System.out.println(ans);
	}
	
	static int calDistance(Point p1, Point p2) {
		int result = Math.abs(p1.y-p2.y) + Math.abs(p1.x - p2.x);
		return result;
	}

	static void select(int idx, int sel, int start) {
		if(idx == sel) {
			
			int sum = 0;
			
			for(int i=0; i<num_h; i++) {
				int min = Integer.MAX_VALUE;
				for(int j=0; j<sel; j++) {
					if(min > calDistance(home[i],result[j])) {
						min = calDistance(home[i],result[j]);
					}
				}
				sum += min;
			}
			
			if(ans > sum) {
				ans = sum;
			}
			
			return;
		}
		
		for(int i=start; i<num_c; i++) {
			result[idx] = chicken[i];
			select(idx+1, sel, i+1);
		}
	}
	
}
