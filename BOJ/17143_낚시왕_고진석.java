import java.io.*;
import java.util.*;

class Main_17143_낚시왕_고진석 {
	static int R, C, M;
	static int[][][] map;
	static int res = 0;
	static int[] dx = {0, -1, 1, 0, 0}, dy = {0, 0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[R][C][3];

		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		for(int i = 0 ; i < R ; i++)
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] == null)
					map[i][j] = new int[]{0, 0, 0};
			}
		
		for(int i = 0 ; i < C ; i++) {
			fishing(i);
			
			move();
		}
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void fishing(int c) {
		for(int i = 0 ; i < R ; i++)
			if(map[i][c][2] > 0) {
				res += map[i][c][2];
				map[i][c][2] = 0;
				return;
			}
	}
	
	public static void move() {
		int[][][] newMap = new int[R][C][3];
		
		for(int i = 0 ; i < R ; i++)
			for(int j = 0 ; j < C ; j++)
				newMap[i][j] = new int[]{0, 0, 0};
		
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				int s = map[i][j][0];
				int d = map[i][j][1];
				int z = map[i][j][2];
				
				int nr = i;
				int nc = j;
				if(z > 0) {
					while(s > 0) {
						nr += dx[d];
						nc += dy[d];
						if(!isIn(nr, nc)) {
							if(d % 2 == 0)
								d--;
							else
								d++;
							nr += dx[d] * 2;
							nc += dy[d] * 2;
						}
						
						s--;
					}
					
					if(newMap[nr][nc][2] < z){
						newMap[nr][nc][0] = map[i][j][0];
						newMap[nr][nc][1] = d;
						newMap[nr][nc][2] = z;
					}
				}
			}
		}
		
		map = newMap;
	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
	
} 