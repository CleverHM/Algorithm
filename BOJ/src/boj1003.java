import java.io.*;
import java.util.*;


public class boj1003 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[][] arr = new int[41][2];
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;
		
		for(int i=2; i<41; i++) {
			arr[i][0] = arr[i-2][0] + arr[i-1][0];
			arr[i][1] = arr[i-2][1] + arr[i-1][1];
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(arr[N][0] +" "+ arr[N][1]);
		}	
	}
}
