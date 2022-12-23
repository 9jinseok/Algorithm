import java.io.*;
import java.util.*;

class Main_23290_마법사상어와복제_고진석{
	static int N = 4, M, S, sx, sy;
	static ArrayList<Integer>[][] map;
	static int[][] smell;
	static int maxKill;
	
	static int[] dx = {0,-1,-1,-1,0,1,1,1}, dy = {-1,-1,0,1,1,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N][N];
		smell = new int[N][N];
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < N ; j++)
				map[i][j] = new ArrayList<>();
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1].add(Integer.parseInt(st.nextToken()) - 1);
		}
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;
		
		for(int s = 0 ; s < S ; s++) {
			//복제
			ArrayList<Integer>[][] copyMap = new ArrayList[N][N];
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j < N ; j++)
					copyMap[i][j] = (ArrayList<Integer>) map[i][j].clone();
			
			//이동
			ArrayList<Integer>[][] moveMap = new ArrayList[N][N];
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j < N ; j++)
					moveMap[i][j] = new ArrayList<>();
			
			int dir, nx, ny;
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j < N ; j++) {
					if(map[i][j].size() > 0) {
						for(int k = 0 ; k < map[i][j].size() ; k++) {
							dir = map[i][j].get(k);
							nx = i + dx[dir];
							ny = j + dy[dir];
							int cnt = 0;
							while(!isIn(nx, ny) || smell[nx][ny] > 0 || (nx == sx && ny == sy)) {
								dir = (dir + 7) % 8;
								nx = i + dx[dir];
								ny = j + dy[dir];
								if(++cnt > 7)
									break;
							}
							if(isIn(nx, ny) && smell[nx][ny] == 0 && (nx != sx || ny != sy)) {
								moveMap[nx][ny].add(dir);
							}
							else {
								moveMap[i][j].add(dir);
							}
						}
					}
				}
			
			//상어이동
			//최대 사냥수 찾기
			maxKill = 0;
			perm(new StringBuilder(), moveMap);
			
			//우선순위대로 돌면서 최대 사냥수인 경우 상어 이동
			perm2(new StringBuilder(), moveMap);
			
			//냄새--
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j < N ; j++)
					if(smell[i][j] > 0)
						smell[i][j]--;
			
			//복제적용
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j < N ; j++) {
					if(smell[i][j] == 2)
						continue;
					for(int k = 0 ; k < moveMap[i][j].size() ; k++)
						copyMap[i][j].add(moveMap[i][j].get(k));
				}
			
			map = copyMap;
		}
		
		int res = 0;
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < N ; j++) {
				res += map[i][j].size();
			}
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void perm(StringBuilder sb, ArrayList<Integer>[][] tmpMap) {
		if(sb.length() == 3) {
			int cnt = 0;
			int dir;
			int nx = sx;
			int ny = sy;
			boolean[][] chk = new boolean[N][N];
			ArrayList<int[]> xy = new ArrayList<>();
			for(char c : sb.toString().toCharArray()) {
				switch(c) {
					case '1':
						dir = 2;
						break;
					case '2':
						dir = 0;
						break;
					case '3':
						dir = 6;
						break;
					case '4':
						dir = 4;
						break;
					default:
						dir = 0;
				}
				nx += dx[dir];
				ny += dy[dir];
				if(!isIn(nx, ny))
					return;
				if(!chk[nx][ny]) {
					chk[nx][ny] = true;
					xy.add(new int[] {nx, ny});
				}
			}
			for(int[] cur : xy)
				cnt += tmpMap[cur[0]][cur[1]].size();
			if(cnt > maxKill) {
				maxKill = cnt;
			}
		}
		else {
			for(int i = 1 ; i <= 4; i++) {
				sb.append(i);
				perm(sb, tmpMap);
				sb.delete(sb.length() - 1, sb.length());
			}
		}
	}
	
	public static boolean perm2(StringBuilder sb, ArrayList<Integer>[][] tmpMap) {
		if(sb.length() == 3) {
			int cnt = 0;
			int dir;
			int nx = sx;
			int ny = sy;
			boolean[][] chk = new boolean[N][N];
			ArrayList<int[]> xy = new ArrayList<>();
			for(char c : sb.toString().toCharArray()) {
				switch(c) {
					case '1':
						dir = 2;
						break;
					case '2':
						dir = 0;
						break;
					case '3':
						dir = 6;
						break;
					case '4':
						dir = 4;
						break;
					default:
						dir = 0;
				}
				nx += dx[dir];
				ny += dy[dir];
				if(!isIn(nx, ny))
					return false;
				if(!chk[nx][ny]) {
					chk[nx][ny] = true;
					xy.add(new int[] {nx, ny});
				}
			}
			for(int[] cur : xy)
				cnt += tmpMap[cur[0]][cur[1]].size();
			if(cnt == maxKill) {
				nx = sx;
				ny = sy;
				for(char c : sb.toString().toCharArray()) {
					switch(c) {
						case '1':
							dir = 2;
							break;
						case '2':
							dir = 0;
							break;
						case '3':
							dir = 6;
							break;
						case '4':
							dir = 4;
							break;
						default:
							dir = 0;
					}
					nx += dx[dir];
					ny += dy[dir];
					if(!tmpMap[nx][ny].isEmpty())
						smell[nx][ny] = 3;
					sx = nx;
					sy = ny;
				}
				return true;
			}
		}
		else {
			for(int i = 1 ; i <= 4; i++) {
				sb.append(i);
				if(perm2(sb, tmpMap))
					return true;
				sb.delete(sb.length() - 1, sb.length());
			}
		}
		return false;
	}
	
	public static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
}
