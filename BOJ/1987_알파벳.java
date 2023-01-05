import java.io.*;
import java.util.*;

public class Main_1987_¾ËÆÄºª {
	static int N, M, max;
	static char[][] map;
	static boolean[] visited;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i = 0 ; i < N ; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0 ; j < M ; j++)
				map[i][j] = input[j];
		}
		
		max = 1;
		visited = new boolean[26];
		dfs(0, 0, 1);
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	public static void dfs(int x, int y, int cnt) {
		visited[map[x][y] - 'A'] = true;
		max = Math.max(max, cnt);
		
		for(int d = 0 ; d < 4 ; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(isIn(nx, ny) && !visited[map[nx][ny] - 'A'])
				dfs(nx, ny, cnt + 1);
		}
		
		visited[map[x][y] - 'A'] = false;
	}
}
