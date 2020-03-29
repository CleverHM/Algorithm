import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj17143 {
	static int R;
	static int C;
	static int M;
	static shark[][] map;
	static ArrayList<shark> sharks;
	static int sum; // 잡은 상어의 무게합.

	private static class shark {
		int r;
		int c;
		int speed;
		int direction;
		int size;

		public shark(int r, int c, int speed, int direction, int size) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}

		@Override
		public String toString() {
			return "shark [r=" + r + ", c=" + c + ", speed=" + speed + ", direction=" + direction + ", size=" + size
					+ "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new shark[R + 1][C + 1];
		sharks = new ArrayList<shark>();

		for (int s = 1; s <= M; s++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			shark sh = new shark(r, c, speed, direction, size);
			map[r][c] = sh;
			sharks.add(sh);
		}
		// 입력 다 받음....

		/**
		 * 1. 낚시왕이 오른쪽으로 한 칸 이동한다. 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면
		 * 격자판에서 잡은 상어가 사라진다. 3. 상어가 이동한다.
		 */

		for (int c = 1; c <= C; c++) {
			fishing(c);
			move();
			eating();
		}

		System.out.println(sum);
	}

	private static void eating() {
		map = new shark[R + 1][C + 1];

		for (int i = 0; i < sharks.size(); i++) {
			shark s = sharks.get(i);

			if (map[s.r][s.c] == null) {
				map[s.r][s.c] = s;
			}

			else {
				if (map[s.r][s.c].size > s.size) {
					sharks.remove(s);
					i--;
				}

				else {
					sharks.remove(map[s.r][s.c]);
					i--;
					map[s.r][s.c] = s;
				}
			}
			
		}

	}

	private static void move() {
		for (int i = (sharks.size())-1; i >= 0; i--) {
			shark s = sharks.get(i);
			int speed = s.speed;

			if (s.direction == 1 || s.direction == 2) {
				speed = speed % (2 * (R - 1));
			} else {
				speed = speed % (2 * (C - 1));
			}

			while (speed > 0) {
				if (s.direction == 1) {
					if (s.r == 1) {
						s.direction = 2;
						(s.r)++;
					} else {
						(s.r)--;
					}
				}

				else if (s.direction == 2) {
					if (s.r == R) {
						s.direction = 1;
						(s.r)--;
					} else {
						(s.r)++;
					}
				}

				else if (s.direction == 3) {
					if (s.c == C) {
						s.direction = 4;
						(s.c)--;
					} else {
						(s.c)++;
					}
				}

				else {
					if (s.c == 1) {
						s.direction = 3;
						(s.c)++;
					} else {
						(s.c)--;
					}
				}

				speed--;
			}
		}
	}

	private static void fishing(int position) {
		shark target = null;

		for (int i = 1; i <= R; i++) {
			if (map[i][position] != null) {
				target = map[i][position];
				break;
			}
		}

		if (target != null) {
			map[target.r][target.c] = null;
			sum += target.size;
			sharks.remove(target);
		}
	}
}
