import java.io.*;
import java.util.*;

public class Main_3109_빵집_고진석 {
	static int[][] map;
	static int R, C;
	static int res = 0;
	static int[] dx = {-1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for(int i = 0 ; i < R ; i++) {
			char[] row = br.readLine().toCharArray();
			for(int j = 0 ; j < C ; j++)
				if(row[j] == 'x')
					map[i][j] = 1; 
		}

		for(int i = 0 ; i < R ; i++) {
			map[i][0] = 1;
			dfs(i, 0);
		}
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int x, int y) {
		if(y == C - 1) {
			res++;
			return;
		}
		else {
			for(int i = 0 ; i < 3 ; i++) {
				int nx = x + dx[i];
				int ny = y + 1;
				if(nx >= 0 && nx < R && map[nx][ny] == 0) {
					int prev = res;
					map[nx][ny] = 1;
					dfs(nx, ny);
					if(prev != res)
						return;
				}
			}
		}
	}
}
