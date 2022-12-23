import java.io.*;
import java.util.StringTokenizer;

class Main_17070_파이프옮기기_고진석 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] dp1 = new long[N + 1][N + 1];
		long[][] dp2 = new long[N + 1][N + 1];
		long[][] dp3 = new long[N + 1][N + 1];
		dp1[1][2] = 1;
		
		for(int i = 1 ; i <= N ; i++)
			for(int j = 3 ; j <= N ; j++) {
				if(map[i][j] == 0) {
					dp1[i][j] = dp1[i][j-1] + dp3[i][j-1];
					dp2[i][j] = dp2[i-1][j] + dp3[i-1][j];
					if(map[i-1][j] == 0 && map[i][j-1] == 0)
						dp3[i][j] = dp1[i-1][j-1] + dp2[i-1][j-1] + dp3[i-1][j-1]; 
				}
			}
		
		bw.write(dp1[N][N] + dp2[N][N] + dp3[N][N] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}

} 