import java.io.*;
import java.util.*;

public class boj17135 {
	static int Y, X, D; // 행의 수, 열의 수 , 궁수의 공격거리 제한.
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[Y + 1][X];
	}
	
	// 해당 지점에서 사방탐색하면서 D범위이하에  적이 있으면 죽인다.(배열값을 -1로 만든다.)
	private static int shot(int y, int x) {
	
		out: for(int range=1; range <= D; range++) {
			for(int d=0; d<4; d++) {
				int ny = y + dir[d][0] * range;
				int nx = x + dir[d][1] * range;
				
				if(isIn(ny, nx) == false) {
					continue;
				}
				
				if(map[ny][nx] == 0) {
					continue;
				}
				
				if(map[ny][nx] == -1) {
					return 0;
				}
				
				if(map[ny][nx] == 1) {
					map[ny][nx] = -1;
					return 1;
				}
			}
		}
	
		return 0;
	}

	private static boolean isIn(int y, int x) {
		return y<0 && x<0 && y > Y-1 && x > X-1;
	}

	static void combination(int cnt, int start) {
		if(cnt == 3) {
			// 성을 순회하면서(마지막줄) 숫자 이면 해당지점에서 발사.
			// 사살한 적의 횟수 카운트.
			int enemy = 0;
			
			for(int x=0; x<X; x++) {
				if(map[Y][x] == 2) {
					enemy += shot(Y,x);
				}
			}
		}
	
		for (int x = start; x < X; x++) {
			map[Y][x] = 2; // 궁수가 있는 지점을 2로 표시
			combination(cnt+1, x+1);
			map[Y][x] = 0; // 궁수가 있는 지점을 0으로 표시(백트래킹)
		}
	}

	
}
