
public class PowerSet {
	static char[] datas = {'A','B','C','D'};
	static boolean[] v;
	public static void main(String[] args) {
		v = new boolean[datas.length];
		dfs(0,datas.length);
	}
	
	static int cnt = 0;
	
	static void print() {
		cnt++;
		System.out.println(cnt + " ");
		for(int i=0; i<datas.length; i++) {
			if(v[i]) {
				System.out.println(datas[i] + " ");
			}
		}
	}
	
	static void dfs(int depth, int MAX) {
		if(depth == MAX) {
			print();
			return;
		}
		
		v[depth] = true;
		dfs(depth + 1, MAX);
		v[depth] = false;
		dfs(depth + 1, MAX);
	}
}
