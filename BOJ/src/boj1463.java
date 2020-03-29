import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[1] = 0;

		for (int i = 1; i < N; i++) {
			if ((i + 1 <= N) && (dp[i + 1] == 0)) {
				dp[i + 1] = dp[i] + 1;
			}

			else {
				if ((i + 1 <= N) && (dp[i + 1] > dp[i] + 1)) {
					dp[i + 1] = dp[i] + 1;
				}
			}

			if ((i * 2 <= N) && (dp[i * 2] == 0)) {
				dp[i * 2] = dp[i] + 1;
			}

			else {
				if ((i * 2 <= N) && (dp[i * 2] > dp[i] + 1)) {
					dp[i * 2] = dp[i] + 1;
				}
			}

			if ((i * 3 <= N) && (dp[i * 3] == 0)) {
				dp[i * 3] = dp[i] + 1;
			}

			else {
				if ((i * 3 <= N) && (dp[i * 3] > dp[i] + 1)) {
					dp[i * 3] = dp[i] + 1;
				}
			}
		}

		System.out.println(dp[N]);

	}

}
