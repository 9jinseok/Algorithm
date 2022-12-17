import java.io.*;
import java.util.*;

class Main_1194_달이차오른다가자_고진석 {
	static int N, M;
	static char[][] map;
	static int x, y;
	static int res = -1;
	static boolean visited[][][];
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[1<<6][N][M];

		for(int i = 0 ; i < N ; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = line[j];
				if(map[i][j] == '0') {
					x = i;
					y = j;
				}
			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{x, y, 0, 0});
		visited[0][x][y] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(map[cur[0]][cur[1]] == '1') {
				res = cur[2];
				break;
			}
			for(int d = 0 ; d < 4 ; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(isIn(nx, ny) && map[nx][ny] != '#' && (map[nx][ny] < 'A' || map[nx][ny] > 'F' || (cur[3] & (1 << map[nx][ny] - 'A')) != 0 )) {
					int nextVisit = cur[3];
					if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f')
						nextVisit |= 1 << map[nx][ny] - 'a';
					if(!visited[nextVisit][nx][ny]) {
						visited[nextVisit][nx][ny] = true;
						q.add(new int[]{nx, ny, cur[2] + 1, nextVisit});
					}
				}
			}
		}	
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
} 