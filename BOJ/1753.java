import java.io.*;
import java.util.*;

class Main_1753_최단경로_고진석{
	static int V, E, root;
	static ArrayList<ArrayList<Edge>> adjList;
	static PriorityQueue<Edge> pq;
	static int[] dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		root = Integer.parseInt(br.readLine());
		adjList = new ArrayList<ArrayList<Edge>>();
		dist = new int[V + 1];
		for(int i = 0 ; i <= V ; i++){
			adjList.add(new ArrayList<Edge>());
			dist[i] = Integer.MAX_VALUE;
		}
		for(int i = 0 ; i < E ; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList.get(u).add(new Edge(v, w));
		}

		pq = new PriorityQueue<Edge>();
		dist[root] = 0;
		pq.add(new Edge(root, 0));
		boolean[] visited = new boolean[V + 1];
		while(!pq.isEmpty()){
			Edge cur = pq.poll();
			int here = cur.to;
			if(visited[here])
				continue;
			visited[here] = true;
			for(Edge next : adjList.get(here)){
				if((dist[here] + next.cost) < dist[next.to]){
					dist[next.to] = dist[here] + next.cost;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}

		for(int i = 1 ; i <= V ; i++){
			if(dist[i] == Integer.MAX_VALUE)
				bw.write("INF\n");
			else
				bw.write(dist[i]+"\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static class Edge implements Comparable<Edge>{
		int to;
		int cost;

		public Edge(int to , int cost){
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return cost - o.cost;
		}
	}
}
