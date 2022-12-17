import java.io.*;
import java.util.*;

class Main_17837_새로운게임2_고진석{
	static int N, K;
	static int[][] color;
	static ArrayDeque<int[]>[][] map;
	static int[][] horses;
	static int[] dx = {0,0,-1,1}, dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		color = new int[N + 2][N + 2];
		for(int i = 0 ; i < N + 2 ; i++)
			Arrays.fill(color[i], 2);
		horses = new int[K][3];
		map = new ArrayDeque[N + 2][N + 2];
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = new ArrayDeque<>();
			}
		}
		
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()) - 1;
			horses[i][0] = a;
			horses[i][1] = b;
			horses[i][2] = c;
			map[a][b].addLast(new int[] {i,c});
		}
		
		int sec = 0;
		while(sec++ < 1000) {
			if(move())
				break;
		}
		
		if(sec > 1000)
			sec = -1;
		bw.write(sec + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean move() {
		int x, y, dir, nx, ny;
		for(int i = 0 ; i < K ; i++) {
			x = horses[i][0];
			y = horses[i][1];
			dir = horses[i][2];
			nx = x + dx[dir];
			ny = y + dy[dir];
			
			if(color[nx][ny] == 2) {
				if(dir % 2 == 0) {
					horses[i][2]++;
					dir++;
				}
				else {
					horses[i][2]--;
					dir--;
				}
				nx = x + dx[dir];
				ny = y + dy[dir];
			}
			
			ArrayDeque<int[]> remain = new ArrayDeque<>();
			if(color[nx][ny] == 0) {
				while(map[x][y].getFirst()[0] != i)
					remain.addLast(map[x][y].pollFirst());
				while(!map[x][y].isEmpty()) {
					int[] cur = map[x][y].pollFirst();
					horses[cur[0]][0] = nx;
					horses[cur[0]][1] = ny;
					map[nx][ny].addLast(cur);
				}
				map[x][y] = remain;
			}
			else if(color[nx][ny] == 1) {
				while(map[x][y].getFirst()[0] != i)
					remain.addLast(map[x][y].pollFirst());
				while(!map[x][y].isEmpty()) {
					int[] cur = map[x][y].pollLast();
					horses[cur[0]][0] = nx;
					horses[cur[0]][1] = ny;
					map[nx][ny].addLast(cur);
				}
				map[x][y] = remain;
			}
			else
				continue;
			if(map[nx][ny].size() >= 4)
				return true;
		}
		return false;
	}
}