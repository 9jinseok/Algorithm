import java.io.*;
import java.util.*;

public class Main_7576_토마토 {
	static int N, M;
	static int[][] map;	
	static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					pq.add(new int[] {i, j, 1});
			}
		}
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			for(int d = 0 ; d < 4 ; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(isIn(nx, ny) && map[nx][ny] == 0) {
					pq.add(new int[] {nx, ny, cur[2] + 1});
					map[nx][ny] = cur[2] + 1;
				}
			}
		}
		
		int max = 0;
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
				if(map[i][j] > max)
					max = map[i][j];
			}
		bw.write(max - 1 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
