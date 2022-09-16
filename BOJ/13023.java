import java.io.*;
import java.util.*;

public class Main_13023_ABCDE_고진석 {
	static int N, M;
	static List<Integer>[] adjList;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new LinkedList[N];
		for(int i = 0 ; i < N ; i++)
			adjList[i] = new LinkedList<>();
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
			adjList[b].add(a);
		}

		visited = new boolean[N];
		for(int i = 0 ; i < N ; i++) {
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false;
		}
		
		bw.write("0\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int cur, int cnt) {
		for(int next : adjList[cur]) {
			if(!visited[next]) {
				if(cnt >= 4) {
					System.out.println("1");
					System.exit(0);
				}
				visited[next] = true;
				dfs(next, cnt + 1);
				visited[next] = false;
			}
		}
	}
	
}
