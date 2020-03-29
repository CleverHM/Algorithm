import java.io.*;
import java.util.*;

public class boj1065 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] result = new int[4];
		int count = 0;
		
		for(int i=1; i<=n; i++) {
			// 각 자리수를 분해하는 작업 필요.
			int idx = 0;
			int copy = i;
			int rem = -1;
			int quo = -1;
			boolean flag = false;
			
			while(quo != 0) {
				rem = copy % 10;
				quo = copy/10;
				result[idx++] = rem;
				copy = quo;
			}
			
			if(idx >= 3) {
				int diff = result[1] - result[0];
				
				for(int j=2; j<idx; j++) {
					if(diff != result[j] - result[j-1]) {
						flag = true;
						break;
					}
				}
			}
			

			if(flag == false) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
