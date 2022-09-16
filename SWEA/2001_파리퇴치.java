import java.util.*;
import java.io.*;

public class 파리퇴치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for(int t = 0 ; t < T ; t++) {
	        st = new StringTokenizer(br.readLine());
	        int N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());
	        
	        int[][] map = new int[N + 1][N + 1];
	        int[][] dp = new int[N + 1][N + 1];
	        for(int i = 1 ; i <= N ; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	for(int j = 1 ; j <= N ; j++) {
	        		map[i][j] = Integer.parseInt(st.nextToken());
	        		dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
	        	}
	        }
	        
	        int max = Integer.MIN_VALUE;
	        for(int i = M ; i <= N  ; i++)
	        	for(int j = M ; j <= N ; j++)
	        		max = Math.max(max, dp[i][j] - dp[i-M][j] - dp[i][j-M] + dp[i-M][j-M]);
	        
	        bw.write("#" + (t+1) + " " + max + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}
}
