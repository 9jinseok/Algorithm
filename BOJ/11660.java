import java.io.*;
import java.util.*;

public class Main_11660_구간합구하기5_고진석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int[][] arr = new int[N][N];
    	int[][] dp = new int[N + 1][N + 1];
    	
    	for(int i = 0 ; i < N ; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j = 0 ; j < N ; j++) {
	    		arr[i][j] = Integer.parseInt(st.nextToken());
	    		dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + arr[i][j];
	    	}
    	}
    	
    	for(int i = 0 ; i < M ; i++) {
    		st = new StringTokenizer(br.readLine());
    		int startX = Integer.parseInt(st.nextToken());
    		int startY = Integer.parseInt(st.nextToken());
    		int endX = Integer.parseInt(st.nextToken());
    		int endY = Integer.parseInt(st.nextToken());
    		
    		bw.write(dp[endX][endY] - dp[endX][startY - 1] - dp[startX - 1][endY] + dp[startX - 1][startY - 1] + "\n");
    	}
    	bw.flush();
    	bw.close();
    	br.close();
	}

}
