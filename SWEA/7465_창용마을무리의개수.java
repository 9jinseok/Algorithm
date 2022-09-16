import java.util.*;
import java.io.*;

class Solution_7465_창용마을무리의개수_고진석 {

	static int N, M;
	static int[] parents; 

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for(int t = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parents = new int[N + 1];
			for(int i = 1 ; i <= N ; i++)
				parents[i] = -1;

			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}

			int cnt = 0;
			for(int i = 1 ; i <= N ; i++)
				if(parents[i] < 0)
					cnt++;
			bw.write("#" + t + " " + cnt + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static int find(int n) {
		if(parents[n] < 0)
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
			parents[parentA] += parents[parentB];
			parents[parentB] = parentA;
			return true;
		}
	}
}
