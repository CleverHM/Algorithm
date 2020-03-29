import java.io.*;
import java.util.*;

public class boj1011 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			long start = Integer.parseInt(st.nextToken());
			long end = Integer.parseInt(st.nextToken());
			long distance = end - start;
			
			if(distance == 1)
				System.out.println(1);
			
			else {
				long cnt = 2;
				long idx = 2;
				int ex = 0;
				
				for(long i=2;;) {
					
					if(distance <= i) {
						System.out.println(cnt);
						break;
					}
					
					i+=idx;
					ex++;
					
					if(ex == 2) {
						ex = 0;
						idx++;
					}
					
					cnt++;
				}
			}
		}
	}
}
