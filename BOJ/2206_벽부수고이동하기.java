import java.io.*;
import java.util.*;

public class Main_2206_벽부수고이동하기 {
	static int N, M;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0 ; j < M ; j++)
				map[i][j] = input[j] - '0';
		}
		
		boolean[][] visited = new boolean[N][M];
		boolean[][] visited1 = new boolean[N][M];
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {0, 0, 1, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == N - 1 && cur[1] == M - 1) {
				System.out.println(cur[2]);
				System.exit(1);
			}
			for(int d = 0 ; d < 4 ; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(isIn(nx, ny)) {
					if(cur[3] == 0) {
						if(map[nx][ny] == 0 && !visited[nx][ny]) {
							q.add(new int[] {nx, ny, cur[2] + 1, 0});
							visited[nx][ny] = true;
						}
						else if(map[nx][ny] == 1) {
							q.add(new int[] {nx, ny, cur[2] + 1, 1});
							visited1[nx][ny] = true;
						}
					}
					else {
						if(map[nx][ny] == 0 && !visited1[nx][ny]) {
							q.add(new int[] {nx, ny, cur[2] + 1, 1});
							visited1[nx][ny] = true;
						}
					}
				}
			}
		}
		
		System.out.println(-1);
	}
	
	public static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
