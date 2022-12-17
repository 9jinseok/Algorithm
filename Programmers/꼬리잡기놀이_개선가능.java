import java.io.*;
import java.util.*;

class 꼬리잡기놀이_개선가능{
	static int N, M, K;
	static int[][] map;
	static int res = 0;
	
	static ArrayList<Node>[] lines;

	static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/**
		lines배열의 인덱스를 통해 어디 팀이 이번 턴에 점수를 얻는 지 알 수 있는데 하나하나 돌면서 비교해서 찾았음
		수정필요
		**/
		boolean visited[][] = new boolean[N][N];
		lines = new ArrayList[M];
		for(int m = 0 ; m < M ; m++) {
			int x = -1, y = -1;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(!visited[i][j] && map[i][j] > 0) {
						x = i;
						y = j;
						break;
					}
				}
				if(x != -1)
					break;
			}
			
			ArrayList<Node> tmp = new ArrayList<>();
			
			Queue<XY> q = new ArrayDeque<>();
			q.add(new XY(x, y));
			visited[x][y] = true;
			
			while(!q.isEmpty()) {
				XY cur = q.poll();
				
				XY left = null, right = null;
				boolean foundLeft = false;
				for(int d = 0 ; d < 4 ; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if(isIn(nx, ny) && map[nx][ny] > 0) {
						if(foundLeft)
							right = new XY(nx, ny);
						else {
							left = new XY(nx, ny);
							foundLeft = true;
						}
						if(!visited[nx][ny]) {
							q.add(new XY(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
				
				tmp.add(new Node(cur, left, right, map[cur.x][cur.y]));
			}
			
			lines[m] = tmp;
		}
		
		for(int k = 0 ; k < K ; k++) {
			move();
			
			shoot(k);
			
//			dump();
		}
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	
	public static void dump() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
	
	public static void move() {
		for(ArrayList<Node> line : lines) {
			for(Node n : line) {
				int leftVal = map[n.left.x][n.left.y];
				int rightVal = map[n.right.x][n.right.y];
				switch(n.val) {
					case 1:
						n.val = Math.min(leftVal, rightVal);
						break;
					case 2:
						n.val = Math.max(leftVal, rightVal);
						break;
					case 3:
						if((leftVal == 1 && rightVal == 2) || (leftVal == 2 && rightVal == 1))
							n.val = 1;
						else
							n.val = Math.max(leftVal, rightVal);
						break;
					case 4:
						if(leftVal == 1 || rightVal == 1)
							n.val = 1;
						break;
				}
			}
			for(Node n : line) {
				map[n.self.x][n.self.y] = n.val;
			}
		}
	}
	
	public static void shoot(int round) {
		int dir = (round % (4 * N))/N;
		int start = round % N;
		
		int x = -1, y = -1;
		switch(dir) {
			case 0:
				for(int i = 0 ; i < N ; i++) {
					if(map[start][i] > 0 && map[start][i] < 4) {
						x = start;
						y = i;
						break;
					}
				}
				break;
			case 1:
				for(int i = N - 1 ; i >= 0 ; i--) {
					if(map[i][start] > 0 && map[i][start] < 4) {
						x = i;
						y = start;
						break;
					}
				}
				break;
			case 2:
				for(int i = N - 1 ; i >= 0 ; i--) {
					if(map[N - 1 - start][i] > 0 && map[N - 1 - start][i] < 4) {
						x = N - 1 - start;
						y = i;
						break;
					}
				}
				break;
			case 3:
				for(int i = 0 ; i < N ; i++) {
					if(map[i][N - 1 - start] > 0 && map[i][N - 1 - start] < 4) {
						x = i;
						y = N - 1 - start;
						break;
					}
				}
				break;
		}
		
		if(x < 0)
			return;
		
		int hx = -1, hy = -1;
		for(ArrayList<Node> line : lines) {
			boolean found = false;
			for(Node n : line) {
				if(n.self.x == x && n.self.y == y) {
					found = true;
					break;
				}
			}
			if(found) {
				for(Node n : line) {
					if(n.val == 1) {
						hx = n.self.x;
						hy = n.self.y;
						break;
					}
				}
				break;
			}
		}
		
		int score = -1;
		if(hx == x && hy == y)
			score = 1;
		else {
			int leftVal = -1, rightVal = -1, lx = -1, ly = -1;
			for(int d = 0 ; d < 4 ; d++) {
				int nx = hx + dx[d];
				int ny = hy + dy[d];
				if(isIn(nx, ny) && map[nx][ny] > 0) {
					if(leftVal < 0) {
						leftVal = map[nx][ny];
						lx = nx;
						ly = ny;
					}
					else {
						rightVal = map[nx][ny];
						if(leftVal == 3 && rightVal == 2) {
							lx = nx;
							ly = ny;
						}
						else if(rightVal < leftVal) { 
							lx = nx;
							ly = ny;
						}
						break;
					}
				}
			}
	
			boolean[][] visited = new boolean[N][N];
			Queue<XY> q = new ArrayDeque<>();
			q.add(new XY(lx, ly));
			visited[hx][hy] = true;
			visited[lx][ly] = true;
			
			int k = 2;
			while(!q.isEmpty()) {
				XY cur = q.poll();
				if(cur.x == x && cur.y == y) {
					score = k;
					break;
				}
				k++;
				for(int d = 0 ; d < 4 ; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if(isIn(nx, ny) && map[nx][ny] > 0 && map[nx][ny] < 4 && !visited[nx][ny]) {
						q.add(new XY(nx, ny));
						visited[nx][ny] = true;
						break;
					}
				}
			}
		}
		
		res += score * score;
		
		for(ArrayList<Node> line : lines) {
			boolean found = false;
			for(Node n : line) {
				if(n.self.x == x && n.self.y == y) {
					found = true;
					break;
				}
			}
			if(found) {
				for(Node n : line) {
					if(n.val == 3) {
						n.val = 1;
						map[n.self.x][n.self.y] = 1;
					}
					else if(n.val == 1) {
						n.val = 3;
						map[n.self.x][n.self.y] = 3;
					}
				}
				break;
			}
		}
	}

	static class Node{
		XY self;
		XY left;
		XY right;
		int val;
		
		public Node(XY self, XY left, XY right, int val) {
			this.self = self;
			this.left = left;
			this.right = right;
			this.val = val;
		}
	}
	
	static class XY{
		int x;
		int y;
		
		public XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
