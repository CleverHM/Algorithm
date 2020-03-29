import java.util.*;

public class boj1697 {
	static int[] check = new int[100001];
	static int subin;
	static int sister;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(check,-1);
		subin = sc.nextInt();
		sister = sc.nextInt();
		bfs();
		System.out.println(check[sister]);
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
//		시작지점을 큐에 넣는다. & 방문처리.
		queue.offer(subin);
		check[subin] = 0;
		
//		큐에서 꺼낸 지점과 연결된 지점이면서 아직 방문하지 않은 노드가 있다면 큐에 넣는다.
		while(!queue.isEmpty()) {
			int s = queue.poll();
			
			int walk1 = s-1;
			
			if(walk1 >=0 && check[walk1] == -1) {
				check[walk1] = check[s]+1;
				queue.offer(walk1);
			}
				
			int walk2 = s+1;
			if(walk2 <=100000 && check[walk2] == -1) {
				check[walk2] = check[s]+1;
				queue.offer(walk2);
			}
			int run = s*2;
			if(run <=100000 && check[run] == -1) {
				check[run] = check[s]+1;
				queue.offer(run);
			}
		}
	}
}
