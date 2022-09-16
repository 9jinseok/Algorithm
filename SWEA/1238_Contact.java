import java.io.*;
import java.util.*;

class Solution_1238_Contact_고진석
{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for(int t = 1 ; t <= 10 ; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			List<Edge> edgeList = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i += 2)
				edgeList.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			
			Queue<Node> q = new ArrayDeque<>();
			q.offer(new Node(start, 1));
			int[] arr = new int[101];
			arr[start] = 1;
			
			while(!q.isEmpty()) {
				Node cur = q.poll();
				for(Edge e : edgeList) {
					if(e.from == cur.n && arr[e.to] == 0) {
						q.offer(new Node(e.to, cur.cnt + 1));
						arr[e.to] = cur.cnt + 1;
					}
				}
			}
			
			int max = 1;
			int res = start;
			for(int i = 1 ; i <= 100 ; i++)
				if(max <= arr[i]) {
					max = arr[i];
					res = i;
				}
			
			bw.write("#" + t + " " + res + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Node {
		int n;
		int cnt;
		
		public Node(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}
	
	static class Edge{
		int from;
		int to;
		
		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
}