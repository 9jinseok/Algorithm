import java.io.*;
import java.util.*;

public class Main_18442_우체국1_고진석 {
	static int V, P;
	static long L;
	static long min;
	static int[] res;
	static long[] home;
	static int[] order;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		
		home = new long[V];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < V ; i++)
			home[i] = Long.parseLong(st.nextToken());
		
		min = Long.MAX_VALUE;
		order = new int[P];
		res = new int[P];
		
		comb(0, 0);
		
		bw.write(min + "\n");
		for(int i = 0 ; i < P ; i++)
			bw.write(home[res[i]] + " ");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void comb(int start, int depth) {
		if(depth == P) {
			long sum = 0;
			for(int i = 0 ; i < V ; i++) {
				long min = Long.MAX_VALUE;
				for(int j = 0 ; j < P ; j++) {
					min = Math.min(min, dist(home[i], home[order[j]]));
				}
				sum += min;
			}
			
			if(sum <= min) {
				min = sum;
				System.arraycopy(order, 0, res, 0, P);
			}
		}
		else {
			if(start >= V)
				return;
			
			comb(start + 1, depth);
			
			order[depth] = start;
			comb(start + 1, depth + 1);
			
		}
	}
	
	public static Long dist(long a, long b) {
		long diff = Math.abs(a - b);
		return Math.min(diff, L - diff);
	}
}
