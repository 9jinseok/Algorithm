import java.io.*;
import java.util.*;

public class Main_16927_배열돌리기2_고진석 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int d = 0 ; d < Math.min(N, M)/2 ; d++) {
			int mod = 2 * (N - 2 * d) + 2 * (M -  2 * d) - 4;
			int newR = R % mod;
			for(int r = 0 ; r < newR ; r++) {
				int tmp = map[d][d];
				for(int i = d ; i < M - d - 1 ; i++)
					map[d][i] = map[d][i+1];
				for(int i = d ; i < N - d - 1 ; i++)
					map[i][M - d - 1] = map[i+1][M - d - 1];
				for(int i = M - d - 1 ; i > d ; i--)
					map[N - d - 1][i] = map[N - d - 1][i-1];
				for(int i = N - d - 1 ; i > d ; i--)
					map[i][d] = map[i-1][d];
				map[d+1][d] = tmp;
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++)
				bw.write(map[i][j] + " ");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}