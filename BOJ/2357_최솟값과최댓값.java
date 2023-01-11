import java.io.*;
import java.util.*;

public class Main_2357_최솟값과최댓값 {
	
	private static Node[] tree;
	private static int[] arr;
	private static int OFFSET;
	
	private static void init(int n) {
		for(OFFSET = 1 ; OFFSET < n ; OFFSET *= 2);
		tree = new Node[OFFSET * 2 + 1];
		for(int i = 0; i < n ; i++)
			tree[OFFSET + i] = new Node(arr[i], arr[i]);
		for(int i = n ; i < OFFSET ; i++)
			tree[OFFSET + i] = new Node(Integer.MIN_VALUE, Integer.MAX_VALUE);
		for(int i = OFFSET - 1 ; i > 0 ; i--)
			tree[i] = new Node(Math.max(tree[i*2].max, tree[i*2 + 1].max), Math.min(tree[i*2].min, tree[i*2 + 1].min));
	}
	
	private static Node query(int from, int to) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		from += OFFSET;
		to += OFFSET;
		while(from <= to) {
			if(from % 2 == 1) {
				max = Math.max(max, tree[from].max);
				min = Math.min(min, tree[from++].min);
			}
			if(to % 2 == 0) {
				max = Math.max(max, tree[to].max);
				min = Math.min(min, tree[to--].min);
			}
			from /= 2;
			to /= 2;
		}
		return new Node(max, min);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i = 0 ; i < N ; i++)
			arr[i] = Integer.parseInt(br.readLine());
		init(N);
		
		int a, b;
		Node res;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			res = query(a, b);
			bw.write(res.min + " " + res.max + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static class Node{
		int max;
		int min;
		
		public Node(int max, int min) {
			this.max = max;
			this.min = min;
		}
	}
}
