import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_1916_최소비용구하기_고진석 {
	static int N, M, S, E;
	static ArrayList<ArrayList<Edge>> adjList;
	static int[] dist;
	static boolean[] visited;
	static PriorityQueue<Edge> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList<>();
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		for(int i = 0 ; i <= N ; i++) {
			adjList.add(new ArrayList<>());
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList.get(from).add(new Edge(to, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<>();
		dist[S] = 0;
		pq.add(new Edge(S, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int here = cur.to;
			if(visited[here])
				continue;
			visited[here] = true;
			for(Edge e : adjList.get(here)) {
				if(e.cost + dist[here] < dist[e.to]) {
					dist[e.to] = e.cost + dist[here];
					pq.add(new Edge(e.to, dist[e.to]));
				}
			}
		}
		
		bw.write(dist[E] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Edge implements Comparable<Edge>{
		int to;
		int cost;
		
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return cost - o.cost;
		}
	}

} 