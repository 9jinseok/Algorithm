import java.io.*;
import java.util.*;

class Solution_1861_정사각형방_고진석 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] arr;
	static int[] res = new int[2];
	static int N;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			res[1] = 0;
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j < N ; j++)
					dfs(i, j, 1, arr[i][j]);
			
			bw.write("#" + t + " " + res[0] + " " + res[1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int x, int y, int cnt, int start) {
		boolean chk = false;
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if(arr[nx][ny] - arr[x][y] == 1) {
				dfs(nx, ny, cnt + 1, start);
				chk = true;
			}
		}
		if(!chk) {
			if(res[1] < cnt || (res[1] == cnt && res[0] > start)) {
				res[0] = start;
				res[1] = cnt;
			}
		}
	}
}