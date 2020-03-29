import java.util.Arrays;

public class Combination {
	static char[] datas = {'A','B','C','D','E'};
	static char[] sel;
	
	public static void main(String[] args) {
		int n = datas.length;
		int r = 3;
		sel = new char[r];
		dfs(n,r);
	}
	
	static int cnt = 0;
	
	static void dfs(int n, int r) {
		if(r==0) {
			cnt++;
			System.out.println(cnt + " : ");
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		if(r > n) {
			return;
		}
		
		sel[r-1] = datas[n-1];
		dfs(n-1,r-1);
		dfs(n-1,r);
	}
}
