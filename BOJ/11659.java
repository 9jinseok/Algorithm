import java.io.*;
import java.util.*;

public class Main_11659_구간합구하기4_고진석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[N];
    	int[] dp = new int[N + 1];
    	dp[0] = 0;
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0 ; i < N ; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		dp[i + 1] = arr[i] + dp[i];
    	}
    	
    	for(int i = 0 ; i < M ; i++) {
    		st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		
    		bw.write(dp[end] - dp[start - 1] + "\n");
    	}
        bw.flush();
        bw.close();
        br.close();
    	
	}

}
