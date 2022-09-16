import java.io.*;
import java.util.*;

public class Main_17135_캐슬디펜스_고진석 {
	static int[][] map, inputMap;
	static int N, M, D;
	static int res = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		inputMap = new int[N][M];
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++)
				inputMap[i][j] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0, 0);
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void comb(int depth, int start, int visited) {
		if(depth == 3) {
			calc(visited);
		}
		else {
			for(int i = start ; i < M ; i++) {
				if((visited & 1 << i) != 0)
					continue;
				comb(depth + 1, i + 1, visited | 1 << i);
			}
		}
	}

	public static void calc(int visited) {
		int[] loc = new int[3];
		int idx = 0;
		for(int i = 0 ; i < M ; i++)
			if((visited & 1 << i) != 0)
				loc[idx++] = i;
		
		for(int i = 0 ; i < N ; i++)
			System.arraycopy(inputMap[i], 0, map[i], 0, M);
		
		int killCnt = 0;
		for(int i = 0 ; i < N ; i++) {
			killCnt += shoot(loc);
			move();
		}
		res = Math.max(res, killCnt);
	}
	
	public static int shoot(int[] loc) {
		Set<Point> set = new HashSet<>();

		for(int x : loc) {
			boolean kill = false;
			for(int d = 1 ; d <= D ; d++) {
				for(int i = d - 1 ; i >= 0 ; i--) {
					if(N - d + i >= 0 && x - i >= 0 && map[N - d + i][x - i] == 1) {
						set.add(new Point(N - d + i, x - i));
						kill = true;
						break;
					}
				}
				if(kill)
					break;
				for(int i = 1 ; i < d ; i++) {
					if(N - d + i >= 0 && x + i < M && map[N - d + i][x + i] == 1) {
						set.add(new Point(N - d + i, x + i));
						kill = true;
						break;
					}
				}
				if(kill)
					break;
			}
		}
		for(Point p : set)
			map[p.x][p.y] = 0;
		return set.size();
	}
	
	public static void move() {
		for(int i = N - 1 ; i > 0 ; i--)
			System.arraycopy(map[i - 1], 0, map[i], 0, M);
		Arrays.fill(map[0], 0);
	}
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			Point p = (Point) o;
			return this.x == p.x && this.y == p.y;
		}
		
		@Override
		public int hashCode() {
			return this.x * 100 + this.y;
		}
	}
}
