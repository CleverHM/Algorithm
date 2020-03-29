import java.util.*;
import java.io.*;

public class boj3190 {

	static int N;
	static int[][] map;
	static DirChange[] arr;
	static boolean flag;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class DirChange {
		int seconds;
		char dir;

		public DirChange(int seconds, char dir) {
			this.seconds = seconds;
			this.dir = dir;
		}
	}

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 맵의 사이즈
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		// 뱀의 초기 위치 표시...
		map[1][1] = 1;

		// 사과의 개수
		int K = sc.nextInt();

		for (int apple = 1; apple <= K; apple++) {
			int a_y = sc.nextInt(); // 사과의 y좌표...
			int a_x = sc.nextInt(); // 사과의 x좌표...
			map[a_y][a_x] = 2; // 사과가 있는 자리는 2로 표시...
		}

		// 뱀의 방향 변환 횟수
		int L = sc.nextInt();
		arr = new DirChange[L];
		sc.nextLine();

		for (int direction = 0; direction < L; direction++) {
			String[] str = sc.nextLine().split(" ");
			int seconds = Integer.parseInt(str[0]); // 게임 시작 시간으로 부터 몇초가 끝난 뒤에 방향을 회전시킬것인지.
			char dir = str[1].charAt(0); // 회전 방향
			arr[direction] = new DirChange(seconds, dir);
		}

		// 시뮬레이션 시작....
		int second = 1; // 초기시간 1초...
		int dir = 1; // 초기방향 오른쪽...
		Queue<Point> snake = new LinkedList<>(); // 뱀의 좌표를 저장할 큐...
		snake.offer(new Point(1,1));
		Point head = new Point(1,1);

		while (true) {
			move(snake, dir, head);

			if (flag == true) {
				break;
			}

			for (int i = 0; i < arr.length; i++) {
				if (arr[i].seconds == second) {
					dir = changeDir(dir, arr[i].dir);
				}
			}

			second++;
		}

		System.out.println(second);

	}

	static void move(Queue<Point> snake, int dir, Point head) {
		int h_x = head.x;
		int h_y = head.y;
		Point nhead;
		

		switch (dir) {
		// 현재 방향이 오른쪽일때
		case 1:
			// 벽을 만나거나 자기자신의 몸과 부딪히면...
			if (h_x + 1 > N || map[h_y][h_x + 1] == 1) {
				flag = true;
				break;
			}
			
			if (map[h_y][h_x + 1] == 0) {
				Point tail = snake.poll();
				map[tail.y][tail.x] = 0;
			} 
			
			map[h_y][h_x + 1] = 1;
			head.x = h_x + 1;
			nhead = new Point(h_y, h_x + 1);
			snake.offer(nhead);
			break;
		// 현재 방향이 아래쪽일때
		case 2:
			// 벽을 만나거나 자기자신의 몸과 부딪히면...
			if (h_y + 1 > N || map[h_y + 1][h_x] == 1) {
				flag = true;
				break;
			}
			
			if (map[h_y + 1][h_x] == 0) {
				Point tail = snake.poll();
				map[tail.y][tail.x] = 0;
			} 
			
			map[h_y + 1][h_x] = 1;
			head.y = h_y + 1;
			nhead = new Point(h_y+1, h_x);
			snake.offer(nhead);
			break;
		// 현재 방향이 왼족일때
		case 3:
			if (h_x - 1 < 1 || map[h_y][h_x - 1] == 1) {
				flag = true;
				break;
			}
			
			if (map[h_y][h_x - 1] == 0) {
				Point tail = snake.poll();
				map[tail.y][tail.x] = 0;
			} 
			
			map[h_y][h_x - 1] = 1;
			head.x = h_x - 1;
			nhead = new Point(h_y, h_x-1);
			snake.offer(nhead);
			break;
		// 현재 방향이 위쪽일때
		case 4:
			if (h_y - 1 < 1 || map[h_y - 1][h_x] == 1) {
				flag = true;
				break;
			}
			
			if (map[h_y - 1][h_x] == 0) {
				Point tail = snake.poll();
				map[tail.y][tail.x] = 0;
			} 
			
			map[h_y - 1][h_x] = 1;
			head.y = h_y - 1;
			nhead = new Point(h_y-1, h_x);
			snake.offer(nhead);
		}
	}

	static int changeDir(int dir, char ch) {
		int nDir = 0;

		switch (dir) {
		case 1:
			if (ch == 'D') {
				nDir = 2;
			} else {
				nDir = 4;
			}
			break;
		case 2:
			if (ch == 'D') {
				nDir = 3;
			} else {
				nDir = 1;
			}
			break;
		case 3:
			if (ch == 'D') {
				nDir = 4;
			} else {
				nDir = 2;
			}
			break;

		case 4:
			if (ch == 'D') {
				nDir = 1;
			} else {
				nDir = 3;
			}
		}

		return nDir;
	}
}
