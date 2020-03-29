import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N; // 고객집의 수
	static int min, CX, CY, HX,HY; // min: 최소이동거리, CX,XY: 회사좌표. HX,HY: 집 좌표.
	static int[][] customers;// 고객 N명 집의 좌표
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			customers = new int[N][2];
			min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			CX = Integer.parseInt(st.nextToken());
			CY = Integer.parseInt(st.nextToken());
			HX = Integer.parseInt(st.nextToken());
			HY = Integer.parseInt(st.nextToken());
			
			// 고객집 좌표
			for(int i=0; i<N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}
			
			go(0,0,CX,CY,0);
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	//count는 숫자의 인덱스,  비트마스킹 visited 이용 , bx by 이전좌표, result 이전좌표에서 거리 누적시킬 변수.
	private static void go(int count, int visited, int bx, int by, int result) {
		// 아직 순열이 완성되지는 않았지만, 이미 기존에 누적되었던 result 값이 기존의 min 값을 넘어버린다면.. 더 이상 순열을 조합할 필요가 음슴.
		if(result >= min) return; 
		
		if(count == N) {
			result += Math.abs(bx-HX) + Math.abs(by-HY);
			if(min > result) {
				min = result;
			}
			return;
		}
		
		for(int i=0; i<N; i++) { // 모든 고객 집을 다 count 위치에 시도.

			if((visited & 1 << i) == 0){// visited & 1 << i : i 고객집이 기존 순열에 처리되었는지 확인:
										// 0 -> 처리안됨, 0아님 -> 처리되었음.
				// visited | (1<<i) : 기존 순열상태에 i고객집 추가
				go(count+1, visited | (1 << i), customers[i][0], customers[i][1], result + Math.abs(bx - customers[i][0]) + Math.abs(by-customers[i][1]));						
			}
										
		}
	}
}
