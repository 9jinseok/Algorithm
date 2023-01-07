import java.io.*;
import java.util.*;

public class Main_6087_레이저통신 {
	static int W, H;
	static int[][] map;
	static int x1 = -1, y1, x2, y2;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
	static int[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for(int i = 0 ; i < H ; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0 ; j < W ; j++) {
				map[i][j] = input[j];
				if(map[i][j] == 'C') {
					if(x1 == -1) {
						x1 = i;
						y1 = j;
					}
					else {
						x2 = i;
						y2 = j;
					}
				}
			}
		}
		
		visited = new int[H][W];
		for(int i = 0 ; i < H ; i++)
			Arrays.fill(visited[i], W*H);
		Queue<int []> q = new ArrayDeque<int[]>();
		for(int d = 0 ; d < 4 ; d++) {
			int nx = x1 + dx[d];
			int ny = y1 + dy[d];
			if(isIn(nx, ny) && map[nx][ny] != '*') {
				q.add(new int[] {nx, ny, d, 0});
				visited[nx][ny] = 0;
			}
		}
		
		int res = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == x2 && cur[1] == y2 && res > cur[3])
				res = cur[3];
			else {
				for(int d = 0 ; d < 4 ; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					int cnt = cur[3];
					if(d != cur[2])
						cnt++;
					if(isIn(nx, ny) && map[nx][ny] != '*' && visited[nx][ny] >= cnt) {
						q.add(new int[] {nx, ny, d, cnt});
						visited[nx][ny] = cnt;
					}
				}
			}
		}
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean isIn(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}
}
