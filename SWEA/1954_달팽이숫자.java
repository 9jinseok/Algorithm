import java.io.*;

class Solution_1954_달팽이숫자_고진석
{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			int x = 0, y = 0;
			int dir = 0;
			int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
			for(int i = 1 ; i <= N * N ; i++) {
				arr[x][y] = i;
				int nx = x + dx[dir], ny = y + dy[dir];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] != 0) {
					dir = (dir + 1) % 4;
					x += dx[dir];
					y += dy[dir];
				}
				else {
					x = nx;
					y = ny;
				}
			}
			
			System.out.println("#" + t);
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
