import java.io.*;
import java.util.*;

class Solution_1247_최적경로_고진석 {
	
	static Point office, home;
	static Point[] customers;
	static boolean[] visited;
	static int ans;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			office = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			customers = new Point[N];
			visited = new boolean[N];
			for(int i = 0 ; i < N ; i++)
				customers[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			ans = Integer.MAX_VALUE;
			dfs(0, office, 0);
			
			bw.write("#" + t + " " + ans + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int depth, Point prev, int cost) {
		if(depth == customers.length)
			ans = Math.min(ans, cost + distance(prev, home));
		else {
			for(int i = 0 ; i < customers.length ; i++) {
				if(visited[i])
					continue;
				visited[i] = true;
				dfs(depth + 1, customers[i], cost + distance(prev, customers[i]));
				visited[i] = false;
			}
		}
	}
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int distance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
}