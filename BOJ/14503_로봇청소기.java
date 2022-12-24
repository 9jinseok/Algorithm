import java.io.*;
import java.util.*;

public class Main_14503_로봇청소기_고진석 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					visited[i][j] = true;
			}
		}
		
		int cnt = 0;
		while(true) {
			if(!visited[x][y]) {
				cnt++;
				visited[x][y] = true;
			}
			boolean possible = false;
			for(int i = 0 ; i < 4 ; i++) {
				int nd = (d + 3 - i) % 4;
				if(!visited[x + dx[nd]][y + dy[nd]]) {
					d = nd;
					possible = true;
					break;
				}
			}
			if(!possible) {
				if(map[x - dx[d]][y - dy[d]] == 1)
					break;
				else {
					x -= dx[d];
					y -= dy[d];
				}
			}
			else {
				x += dx[d];
				y += dy[d];
			}
		}
		
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
