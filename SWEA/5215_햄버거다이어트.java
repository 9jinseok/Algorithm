import java.util.*;
import java.io.*;

class Solution_햄버거다이어트_고진석 {
	static int[][] arr;
	static int[] input;
	static int res = 0;
	static int L;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			arr = new int[N][2]; 
			input = new int[N];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			res = 0;
			for(int i = 1 ; i <= N ; i ++)
				comb(0, 0, N, i);
			
			bw.write("#" + t + " " + res + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void comb(int cnt, int start, int n, int r) {
		if(cnt == r) {
			int sSum = 0;
			int cSum = 0;
			for(int i = 0 ; i < r ; i++) {
				sSum += arr[input[i]][0];
				cSum += arr[input[i]][1];
			}
			if( cSum <= L )
				res = Math.max(res, sSum);
		}
		else {
			for(int i = start ; i < n ; i++) {
				input[cnt] = i;
				comb(cnt + 1, i + 1, n, r);
			}
		}
	}
}