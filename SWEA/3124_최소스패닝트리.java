import java.util.*;
import java.io.*;

class Solution_3124_최소스패닝트리_고진석 {

	static int V, E;
	static List<Edge> edgeList;
	static int[] parents; 

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for(int t = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			edgeList = new ArrayList<>();
			for(int i = 0 ; i < E ; i++) {
				st = new StringTokenizer(br.readLine());
				edgeList.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			parents = new int[V + 1];
			for(int i = 1 ; i <= V ; i++)
				parents[i] = i;
			Collections.sort(edgeList);

			long res = 0;
			int cnt = 0;
			for(Edge e : edgeList) {
				if(union(e.from, e.to)) {
					res += e.weight;
					if(++cnt == V - 1)
						break;
				}
			}

			bw.write("#" + t + " " + res + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static int find(int n) {
		if(parents[n] == n)
			return n;
		else
			return parents[n] = find(parents[n]);
	}

	public static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		if(parentA == parentB)
			return false;
		else {
			parents[parentB] = parentA;
			return true;
		}
	}

	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
}
