import java.io.*;
import java.util.*;

class Main_19238_스타트택시_고진석{
	static int N, M, L, tx, ty;
	static int[][] map;
	static int[][] goalList;
	static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				if(Integer.parseInt(st.nextToken()) == 0)
					map[i][j] = 0;
				else
					map[i][j] = -1;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		tx = Integer.parseInt(st.nextToken()) - 1;
		ty = Integer.parseInt(st.nextToken()) - 1;
		
		goalList = new int[M + 1][2];
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = i + 1;
			goalList[i + 1] = new int[] {c, d};
		}
		
		for(int i = 0 ; i < M ; i++) {
			//승객 찾기
			boolean[][] visited = new boolean[N][N];
			
			PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
				if(o1[2] == o2[2]) {
					if(o1[0] == o2[0])
						return o1[1] - o2[1];
					else
						return o1[0] - o2[0];
				}
				else
					return o1[2] - o2[2];
			});
			
			q.add(new int[] {tx, ty, 0});
			visited[tx][ty] = true;
			
			int goal = -1, cost = 0;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				if(map[cur[0]][cur[1]] > 0 && map[cur[0]][cur[1]] <= M) {
					goal = map[cur[0]][cur[1]];
					tx = cur[0];
					ty = cur[1];
					cost = cur[2];
					map[cur[0]][cur[1]] = 0;
					break;
				}
				for(int d = 0 ; d < 4 ; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					if(!isIn(nx, ny) || map[nx][ny] < 0 || visited[nx][ny])
						continue;
					q.add(new int[] {nx, ny, cur[2] + 1});
					visited[nx][ny] = true;
				}
			}
			
			L -= cost;
			if(L < 0 || goal == -1) {
				System.out.println("-1");
				return;
			}
			
			q.clear();
			visited = new boolean[N][N];
			cost = 0;
			
			q.add(new int[] {tx, ty, 0});
			visited[tx][ty] = true;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				if(cur[0] == goalList[goal][0] && cur[1] == goalList[goal][1]) {
					tx = cur[0];
					ty = cur[1];
					cost = cur[2];
					break;
				}
				for(int d = 0 ; d < 4 ; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					if(!isIn(nx, ny) || map[nx][ny] < 0 || visited[nx][ny])
						continue;
					q.add(new int[] {nx, ny, cur[2] + 1});
					visited[nx][ny] = true;
				}
			}
			
			if(cost > L || cost == 0) {
				System.out.println("-1");
				return;
			}
			L += cost;
		}
		
		bw.write(L + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
