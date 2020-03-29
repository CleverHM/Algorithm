import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj12100 {

	static int N;
	static int[][] map;
	static int[][] copy;
	static int[] result; // 이동방향 순서를 배치할 배열.(중복순열)
	static int max = -1; // 블록이 합쳐질때마다 최댓값이 갱신될 변수.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		copy = new int[N][N];
		result = new int[5];
		StringTokenizer st = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (max < map[i][j])
					max = map[i][j];
			}
		}
		// 입력 완료 및 최댓값 초기화

		permutation(0);
		
		System.out.println(max);

	}

	private static void permutation(int cnt) {
		if (cnt == 5) {
			
			for(int i=0; i<N; i++) {
				copy[i] = map[i].clone();
			}
			
			for (int d = 0; d < 5; d++) {
				boolean[][] check = new boolean[N][N];

				switch (result[d]) {
				case 1:
					moveUp();
					break;
				case 2:
					moveDown();
					break;
				case 3:
					moveLeft();
					break;
				case 4:
					moveRight();
					break;
				}
			}
			
			
			for(int i=0; i<N; i++) {
				map[i] = copy[i].clone();
			}
			
			return;

		}

		for (int i = 1; i < 5; i++) {
			result[cnt] = i;
			permutation(cnt + 1);
		}
	}

	private static void moveRight() {

		boolean[][] check = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = N - 2; j >= 0; j--) {
				if (map[i][j] != 0) {
					for (int nj = j; nj < N - 1; nj++) {
						if (map[i][nj + 1] == 0) {
							int temp = map[i][nj + 1];
							map[i][nj + 1] = map[i][nj];
							map[i][nj] = temp;
						}

						else {

							if (check[i][nj + 1] == true) {
								break;
							}

							if (map[i][nj] != map[i][nj + 1]) {
								break;
							}

							map[i][nj + 1] += map[i][nj];
							if(max < map[i][nj+1]) {
								max = map[i][nj+1];
							}
							check[i][nj + 1] = true;
							map[i][nj] = 0;
							break;
						}

					}
				}
			}
		}

	}

	private static void moveLeft() {
		
		boolean[][] check = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] != 0) {
					for (int nj = j; nj > 0; nj--) {
						if (map[i][nj - 1] == 0) {
							int temp = map[i][nj - 1];
							map[i][nj - 1] = map[i][nj];
							map[i][nj] = temp;
						}

						else {

							if (check[i][nj - 1] == true) {
								break;
							}

							if (map[i][nj] != map[i][nj - 1]) {
								break;
							}

							map[i][nj - 1] += map[i][nj];
							if(max < map[i][nj-1]) {
								max = map[i][nj-1];
							}
							check[i][nj - 1] = true;
							map[i][nj] = 0;
							break;
						}
					}
				}
			}
		}

	}

	private static void moveDown() {
		boolean[][] check = new boolean[N][N];

		for (int j = 0; j < N; j++) {
			for (int i = N-2; i >=0; i--) {
				if (map[i][j] != 0) {
					for (int ni = i; ni < N-1; ni++) {
						if (map[ni+1][j] == 0) {
							int temp = map[ni+1][j];
							map[ni+1][j] = map[ni][j];
							map[ni][j] = temp;
						}

						else {

							if (check[ni+1][j] == true) {
								break;
							}

							if (map[ni][j] != map[ni+1][j]) {
								break;
							}

							map[ni+1][j] += map[ni][j];
							if(max < map[ni+1][j]) {
								max = map[ni+1][j];
							}
							check[ni+1][j] = true;
							map[ni][j] = 0;
							break;
						}
					}
				}
			}
		}
	}

	private static void moveUp() {
		boolean[][] check = new boolean[N][N];

		for (int j = 0; j < N; j++) {
			for (int i = 1; i < N; i++) {
				if (map[i][j] != 0) {
					for (int ni = i; ni >= 1; ni--) {
						if (map[ni-1][j] == 0) {
							int temp = map[ni-1][j];
							map[ni-1][j] = map[ni][j];
							map[ni][j] = temp;
						}

						else {

							if (check[ni-1][j] == true) {
								break;
							}

							if (map[ni][j] != map[ni-1][j]) {
								break;
							}

							map[ni-1][j] += map[ni][j];
							if(max < map[ni-1][j]) {
								max = map[ni-1][j];
							}
							check[ni-1][j] = true;
							map[ni][j] = 0;
							break;
						}
					}
				}
			}
		}

	}

}
