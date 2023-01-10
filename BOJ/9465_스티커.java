import java.io.*;
import java.util.*;

public class Main_9465_½ºÆ¼Ä¿{
	static int T, N;
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	T = Integer.parseInt(br.readLine());
    	for(int t = 0 ; t < T ; t++) {
    		N = Integer.parseInt(br.readLine());
    		int[][] arr = new int[2][N];
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0 ; i < N ; i++)
    			arr[0][i] = Integer.parseInt(st.nextToken());
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0 ; i < N ; i++)
    			arr[1][i] = Integer.parseInt(st.nextToken());
    		
    		int[][] dp = new int[N][3];
    		dp[0][1] = arr[0][0];
    		dp[0][2] = arr[1][0];
    		for(int i = 1 ; i < N ; i++) {
    			dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
    			dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + arr[0][i];
    			dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + arr[1][i];
    		}
    		
    		System.out.println(Math.max(Math.max(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
    	}
    }
}