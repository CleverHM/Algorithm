import java.util.Scanner;

public class swea7965 {
	static long N;
	static long sum;
	static int mem[] = new int[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			sum = 0;
			powSum();
			System.out.println("#" + tc +" "+ sum % 1000000007);
		}
	}
	static long pow(long base, long exp) {
		if (exp == 0) {
			return 1;
		} else if (exp == 1) {
			return base;
		}
		
		
		System.out.println();

		//메모이제이션 배열에 데이터가 없는 경우에만 재귀호출.
		if(mem[(int)base] == 0) {
			
			long result = (pow(base, exp / 2));
			result = (result  * result) % 1000000007;
			

			if (exp % 2 == 1) {
				result = result * base;
			}
			
			if(base == exp) {
				mem[(int)base] = (int)(result % 1000000007);
			}
			
			return result % 1000000007;
		}
		
		return mem[(int)base];
	}

	static void powSum() {
		for (int i = 1; i <= N; i++) {
			sum = (sum % 1000000007) + pow(i, i);
		}
	}
}
