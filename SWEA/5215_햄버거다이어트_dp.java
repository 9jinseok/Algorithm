import java.util.*;
import java.io.*;

class Solution_5215_햄버거다이어트_고진석 {
	static int[][] arr;
	static int[][] dp;
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
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[N + 1][L + 1];
			
			for(int i = 1 ; i <= N ; i++) {
				for(int w = 1 ; w <= L ; w++) {
					if(w < arr[i - 1][1])
						dp[i][w] = dp[i - 1][w];
					else {
						dp[i][w] = Math.max(dp[i - 1][w - arr[i - 1][1]] + arr[i - 1][0], dp[i - 1][w]);
					}
				}
			}
			bw.write("#" + t + " " + dp[N][L] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}