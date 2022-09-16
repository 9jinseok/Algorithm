import java.io.*;
import java.util.*;

public class Main_16236_아기상어_고진석 {
	static int N, F;
	static int[][] map;
	static List<Fish> fishList;
	static boolean[] visited;
	static int x, y, size, eat;
	static int sec = 0;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		fishList = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					x = i;
					y = j;
					size = 2;
					eat = size;
					map[i][j] = 0;
				}
				else if(map[i][j] > 0)
					fishList.add(new Fish(i, j, map[i][j]));
			}
		}
		F = fishList.size();
		Collections.sort(fishList);
		for(int i = 0 ; i < F ; i++)
			fishList.get(i).idx = i;
		visited = new boolean[F];
		
		while(true) {
			List<Fish> small = new ArrayList<>();
			for(Fish f : fishList)
				if(!visited[f.idx] && f.size < size)
					small.add(f);
			if(small.isEmpty())
				break;
			
			int min = N * N;
			Fish next = null;
			for(Fish f : small) {
				int distance = move(f.x, f.y);
				if(min > distance) {
					min = distance;
					next = f;
				}
			}
			
			if(next == null)
				break;
			visited[next.idx] = true;
			x = next.x;
			y = next.y;
			map[x][y] = 0;
			if(--eat == 0) {
				size++;
				eat = size;
			}
			sec += min;
		}
		
		bw.write(sec + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	public static int move(int targetX, int targetY) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y, 0});
		boolean[][] visited2 = new boolean[N][N];
		visited2[x][y] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == targetX && cur[1] == targetY)
				return cur[2];
			for(int d = 0 ; d < 4 ; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(!isIn(nx, ny) || visited2[nx][ny] || map[nx][ny] > size)
					continue;
				q.offer(new int[] {nx, ny, cur[2] + 1});
				visited2[nx][ny] = true;
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
	static class Fish implements Comparable<Fish>{
		int x;
		int y;
		int size;
		int idx;
		
		public Fish(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.x == o.x)
				return this.y - o.y;
			return this.x - o.x;
		}
	}
}
