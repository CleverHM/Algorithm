import java.util.*;
import java.io.*;

public class boj12851 {
	static int subin;
	static int sister;
	static int[] check = new int[100001]; // 각각의 목적지에 몇초에 도착했는지 기록하는 배열.
	static int[] count = new int[100001]; // 각각의 목적지에 최단시간으로 도착하는 방법의 숫자를 기록하는 배열.

	static class Point {
		int dest;
		int seconds;

		public Point(int dest, int seconds) {
			this.dest = dest;
			this.seconds = seconds;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		subin = sc.nextInt();
		sister = sc.nextInt();
		bfs();
		System.out.println(check[sister]);
		System.out.println(count[sister]);
	}

	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(subin, 0));

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int dest = p.dest;
			int seconds = p.seconds;
			
			if((dest == subin) && (dest == sister)) {
				count[sister] = 1;
				break;
			}
			
			if(dest < 0 || dest > 100000) {
				continue;
			}

			if ((check[dest] != 0) && (check[dest] < seconds)) {
				continue;
			}
			
			check[dest] = seconds;
			(count[dest])++;

			int time = seconds + 1;

			int walk1 = dest - 1;
			queue.offer(new Point(walk1, time));

			int walk2 = dest + 1;
			queue.offer(new Point(walk2, time));

			int run = dest * 2;
			queue.offer(new Point(run, time));

		}
	}
}
