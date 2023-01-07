import java.io.*;
import java.util.*;

public class Main_15685_드래곤커브 {
	static int N;
	static boolean[][] map = new boolean[101][101];
	static int[] dir = new int[1 << 10];
	static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		int idx = 0;
		for(int i = 0 ; i < 10 ; i++) {
			int tmp = idx;
			dir[idx++] = 1;
			for(int j = tmp - 1 ; j >= 0 ; j--)
				dir[idx++] = -dir[j];
		}
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			map[x][y] = true;
			map[nx][ny] = true;
			for(int j = 0 ; j < (1 << g) - 1 ; j++) {
				d = (d + dir[j] + 4) % 4;
				nx += dx[d];
				ny += dy[d];
				map[nx][ny] = true;
			}
		}
		
		int res = 0;
		
		for(int i = 0 ; i < 100 ; i++)
			for(int j = 0 ; j < 100 ; j++) {
				if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1])
					res++;
			}
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
}
