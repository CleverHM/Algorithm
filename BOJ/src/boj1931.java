import java.util.*;
import java.io.*;

public class boj1931 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];	
		
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		// 클래스 배열 끝나는 시간대로 정렬....
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
			
		});
		
		int end = arr[0][1];
		int count = 1;
		
		for(int i=1; i<n; i++) {
			if(arr[i][0] < end)
				continue;
			end = arr[i][1];
			count++;	
		}
		
		System.out.println(count);
	}
}
