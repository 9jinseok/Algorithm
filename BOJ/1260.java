import java.io.*;
import java.util.*;

public class Main_1260_DFS와BFS_고진석 {
	static int[][] map;
	static BufferedWriter bw;
	static boolean[] visited;
	static int N, M, V;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end] = 1;
			map[end][start] = 1;
		}
		
		visited = new boolean[N + 1];
		dfs(V);
		bw.write("\n");
		
		bfs(V);
		bw.write("\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int cur) throws Exception {
		bw.write(cur + " ");
		visited[cur] = true;
		for(int i = 1 ; i <= N ; i++){
			if(!visited[i] && map[cur][i] == 1)
				dfs(i);
		}
	}
	
	public static void bfs(int start) throws Exception {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = false;
		while(!q.isEmpty()) {
			int cur = q.poll();
			bw.write(cur + " ");
			for(int i = 1 ; i <= N ; i++) {
				if(visited[i] && map[cur][i] == 1) {
					q.offer(i);
					visited[i] = false;
				}
			}
		}
	}
}
