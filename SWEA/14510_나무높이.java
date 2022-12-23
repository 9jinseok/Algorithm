import java.util.*;
import java.io.*;

class Solution_14510_나무높이_고진석 {
	static int N;
	static int[] trees;
	static int res;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T ; t++) {
			N = Integer.parseInt(br.readLine());
			
			trees = new int[N];
			
			int max = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, trees[i]);
			}
			
			int sum = 0;
			for(int i = 0 ; i < N ; i++) {
				trees[i] = max - trees[i];
				sum += trees[i];
			}
			
			res = sum / 3 * 2;
			if(sum % 3 == 1)
				res++;
			else if(sum % 3 == 2)
				res += 2;
			
			int two = 0;
			for(int i : trees) {
				while(i >= 2) {
					i -= 2;
					two++;
				}
			}
			
			if(sum > two * 3)
				res = two * 2;
			int remain = sum - two * 3;
			if(remain > 0) {
				remain--;
				res++;
				while(remain-- > 0)
					res += 2;
			}
			
			bw.write("#" + t + " " + res + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
