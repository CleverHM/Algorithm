import java.util.Scanner;

public class boj2669 {
	static int[][] map = new int[100+1][100+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		
		for(int i=1; i<=4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int y=y1; y<y2; y++) {
				for(int x=x1; x<x2; x++) {
					map[y][x] = 1;
				}
			}
		}
		
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(map[i][j] == 1) {
					ans += 1;
				}
			}
		}
		
		System.out.println(ans);
	}
}
