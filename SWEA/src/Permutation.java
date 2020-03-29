import java.util.*;
import java.io.*;

public class Permutation {
	static int[] arr;
	static boolean[] visited;
	static int[] result;
	static int N;
	static int R;
	static int cnt;
	
	public static void main(String[] args) {
		arr = new int[] {1,2,3,4};
		N = arr.length;
		R = 2;
		visited = new boolean[arr.length];
		result = new int[R];
		dfs(0);
	}
	
	static void dfs(int depth) {
		if(depth == R) {
			cnt++;
			System.out.println(cnt + " ");
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(visited[i] == true)
				continue;
			visited[i] = true;
			result[depth] = arr[i];
			dfs(depth+1);
			visited[i] = false;
		}
	}
}
