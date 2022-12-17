import java.io.*;

class Main_1463_1로만들기_고진석 {
	static int[] dp = new int[1000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp[1] = 0;
		for(int i = 2 ; i <= 1000000 ; i++) {
			if(i % 6 == 0)
				dp[i] = Math.min(Math.min(dp[i - 1], dp[i/3]), dp[i/2]) + 1;
			else if(i % 3 == 0)
				dp[i] = Math.min(dp[i - 1], dp[i/3]) + 1;
			else if(i % 2 == 0)
				dp[i] = Math.min(dp[i - 1], dp[i/2]) + 1;
			else
				dp[i] = dp[i - 1] + 1;
		}
		
		int N = Integer.parseInt(br.readLine());
		System.out.println(dp[N]);
	}
} 