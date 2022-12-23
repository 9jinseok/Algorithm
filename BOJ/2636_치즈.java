import java.io.*;
import java.util.*;

class Main_2636_치즈_고진석 {
	static int N, M;
	static int[][] map;
	static int cheeseCnt = 0;
	static Queue<int[]> q;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];

		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					cheeseCnt++;
			}
		}
		
		int prev = 0;
		int cnt = 0;
		while(cheeseCnt > 0) {
			prev = cheeseCnt;
			cnt++;
			melt();
		}
		
		bw.write(cnt + "\n" + prev + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean isOut(int r, int c) {
		boolean res = false;
		
		q = new ArrayDeque<>();
		visited = new boolean[N][M];
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == 0 || cur[1] == 0 || cur[0] == N - 1 || cur[1] == M - 1) {
				res = true;
				break;
			}
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = cur[0] + dx[d];
				int nc = cur[1] + dy[d];
				if(map[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
		}
		
		return res;
	}
	
	public static void melt() {
		boolean[][] chk = new boolean[N][M];
		
		for(int i = 1 ; i < N - 1 ; i++) {
			for(int j = 1 ; j < M - 1 ; j++) {
				if(map[i][j] == 1 && isOut(i, j)) {
					chk[i][j] = true;
				}
			}
		}
		
		for(int i = 1 ; i < N - 1 ; i++) {
			for(int j = 1 ; j < M - 1 ; j++) {
				if(chk[i][j]) {
					cheeseCnt--;
					map[i][j] = 0;
				}
			}
		}
		
	}
} 