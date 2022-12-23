import java.io.*;
import java.util.*;

public class Main_2931_가스관_고진석 {
	static int R, C;
	static int[][] map;
	static boolean[][] visited;
	static int mx, my, ax, ay;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
					// 상, 좌, 하, 우
	static int[][] dir = {{},{2,3},{0,3},{0,1},{1,2},{0,2},{1,3},{0,1,2,3}};
//각 블록마다 열린 방향 : 1번부터   우하,   상우,  상좌,  좌하,   상하,  좌우,  상하좌우

//전략 : 각 블록마다 열린 방향을 dir 배열에 미리 만들어두고 집에서 출발하여 블록을 따라 탐색하면서 해당 블록에서 열린 방향이지만 블록이 없는 경우를 찾아 그 위치를 ax, ay에 저장해둔다.
//		ax, ay가 지워진 위치이고 해당 위치에서 사방을 탐색하며 열려있어야 하는 방향을 requiredDir 배열에 저장해둔다.
// 		마지막으로 dir배열과 requiredDir배열을 비교하면서 지워진 위치에 어떤 블록이 있어야 하는지 판단해준다.
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		//각 테스트 케이스마다 입력을 받고 자료구조를 초기화 해준다.
		map = new int[R][C];
		visited = new boolean[R][C];
		for(int i = 0 ; i < R ; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0 ; j < C ; j++) {
				//char배열에 받은 입력에 대해 int로 치환하여 map에 넣어준다.
				// 빈칸은 0 
				if(input[j] == '.') {
					visited[i][j] = true;
				}
				else {
					// |, -, + 블록은 각각 5, 6, 7
					if(input[j] == '|')
						map[i][j] = 5;
					else if(input[j] == '-')
						map[i][j] = 6;
					else if(input[j] == '+')
						map[i][j] = 7;
					//M, Z는 -1
					else if(input[j] == 'M') {
						mx = i;
						my = j;
						map[mx][my] = -1;
						visited[mx][my] = true;
					}
					else if(input[j] == 'Z') {
						map[i][j] = -1;
					}
					// 1 ~ 4번 블록은 숫자 1 ~ 4
					else
						map[i][j] = input[j] - '0';
				}
			}
		}
		
		//M위치에 대해 사방을 탐색하며 블록이 있는 위치를 시작점으로 잡는다(M과 Z는 하나의 블록과만 인접해 있으므로 해당 블록의 모양은 체크하지 않음)
		for(int d = 0 ; d < 4 ; d++) {
			int nx = mx + dx[d]; 
			int ny = my + dy[d];
			if(isIn(nx, ny) && map[nx][ny] > 0) {
				mx = nx;
				my = ny;
				break;
			}
		}
		
		//시작점부터 BFS로 탐색
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {mx, my});
		visited[mx][my] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(map[cur[0]][cur[1]] <= 0)
				continue;
			int[] possibleDir = dir[map[cur[0]][cur[1]]];
			//위에 미리 계산해둔 각 블록의 모양마다 열려있는 방향을 possibleDir 배열에 받아온다.
			for(int d : possibleDir) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				
				//열려있는 모든 방향에 대해 탐색하면서 해당 위치에 블록이 없을 경우 그 위치가 지워진 것이므로 ax, ay에 저장해준다.
				if(isIn(nx,ny) && map[nx][ny] != 0) {
					if(!visited[nx][ny]) {
						q.add(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}
				else {
					ax = nx;
					ay = ny;
					break;
				}
			}
		}
		
		//ax, ay로부터 사방을 탐색하면서 각 방향에 블록이 있고 그 블록이 ax, ay 위치에 열려있을 경우 그 방향을 requiredDir 배열에 넣어준다.
		//ax, ay 위치에 있어야 할 지워진 블록은 requiredDir에 저장된 모든 방향에 열린 블록이어야 한다.
		int cnt = 0;
		int[] requiredDir = new int[4];
		for(int d = 0 ; d < 4 ; d++) {
			int nx = ax + dx[d];
			int ny = ay + dy[d];
			
			if(isIn(nx, ny) && map[nx][ny] > 0) {
				int[] possibleDir = dir[map[nx][ny]];
				boolean chk = false;
				for(int dd : possibleDir) {
					if(nx + dx[dd] == ax && ny + dy[dd] == ay) {
						chk = true;
						break;
					}
				}
				if(chk) {
					requiredDir[cnt++] = d;
				}
			}
		}
		
		//가능한 모든 블록을 탐색하며 지워진 ax, ay 위치에 필요한 블록이 무엇인지 판단한다.
		//각 블록에 대해 requiredDir배열과 열린 방향이 모두 일치한 경우를 찾는다.
		int ans = -1;
		for(int i = 1 ; i <= 7 ; i++) {
			if(dir[i].length != cnt)
				continue;
			boolean chk = true;
			for(int j = 0 ; j < cnt ; j++) {
				if(dir[i][j] != requiredDir[j]) {
					chk = false;
					break;
				}
			}
			if(chk) {
				ans = i;
				break;
			}
		}
		
		//구한 답은 ans 변수에 int 형태로 저장되어 있으므로 출력 형식에 맞게 char로 바꿔준다.
		char res = '.';
		if(ans == 5) {
			res = '|';
		}
		else if(ans == 6) {
			res = '-';
		}
		else if(ans == 7) {
			res = '+';
		}
		else
			res = (char) (ans + '0');
		
		//테스트케이스마다 지워진 위치 ax, ay와 지워진 블록의 모양을 출력해준다.
		bw.write((ax + 1) + " " + (ay + 1) + " " + res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	//x, y가 범위를 벗어나지 않는지 체크해주는 함수
	public static boolean isIn(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}
