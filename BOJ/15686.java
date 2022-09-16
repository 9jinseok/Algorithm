import java.io.*;
import java.util.*;

public class Main_15686_치킨배달_고진석 {
	static List<Point> house = new ArrayList<>();
	static List<Point> chicken = new ArrayList<>();
	static int[] selected;
	static boolean[] visited;
	static int N, M;
	
	static int res = Integer.MAX_VALUE;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1)
					house.add(new Point(i, j));
				if(arr[i][j] == 2)
					chicken.add(new Point(i, j));
			}
		}
		
		selected = new int[M];
		visited = new boolean[chicken.size()];
		for(int i = 0 ; i < chicken.size() ; i++) {
			visited[i] = true;
			select(i, 0);
			visited[i] = false;
		}
		
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void select(int start, int depth) {
		selected[depth] = start;
		if(depth == M - 1) {
			res = Math.min(res, cDist());
		}
		else {
			for(int i = start + 1 ; i < chicken.size() ; i++) {
				if(visited[i])
					continue;
				visited[i] = true;
				select(i, depth + 1);
				visited[i] = false;
			}
		}
	}
	
	static int cDist() {
		int sum = 0;
		for(int i = 0 ; i < house.size() ; i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0 ; j < M ; j++) {
				min = Math.min(min, distance(house.get(i), chicken.get(selected[j])));
			}
			sum += min;
		}
		return sum;
	}
	
	static int distance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y); 
	}
	
	static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}