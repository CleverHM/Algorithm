import java.util.Scanner;

public class boj2476 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = -1;
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			int num3 = sc.nextInt();
			int result = 0;

			if ((num1 == num2) && (num2 == num3)) {
				result = 10000 + num1 * 1000;
			}

			else if ((num1 == num2) && (num2 != num3)) {
				result = 1000 + num1 * 100;
			}

			else if ((num2 == num3) && (num1 != num2)) {
				result = 1000 + num2 * 100;
			}

			else if ((num1 == num3) && (num1 != num2)) {
				result = 1000 + num1 * 100;
			}

			else {
				int mx = 0;
				
				if(num1 < num2) {
					mx = num2;
					
					if(num2 < num3) {
						mx = num3;
					}
				}
				
				else {
					mx = num1;
					
					if(num1 < num3) {
						mx = num3;
					}
				}
				
				result = mx*100;
			}
			
			if(result > max) {
				max = result;
			}
		}
		
		System.out.println(max);
	}
}
