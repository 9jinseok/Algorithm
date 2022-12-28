import java.io.*;
import java.util.*;

public class Main_14500_테트로미노 {
	static int N, M;
	static int[][] map;	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 5][M + 5];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				//일자
				max = Math.max(max, map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3]);
				max = Math.max(max, map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j]);
				//네모
				max = Math.max(max, map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1]);
				//ㅗ
				max = Math.max(max, map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+1]);
				max = Math.max(max, map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1]);
				max = Math.max(max, map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+1][j]);
				max = Math.max(max, map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1]);
				//ㄴ
				max = Math.max(max, map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1]);
				max = Math.max(max, map[i][j] + map[i+1][j] + map[i+2][j] + map[i][j+1]);
				max = Math.max(max, map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i][j]);
				max = Math.max(max, map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+2][j]);
				max = Math.max(max, map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j]);
				max = Math.max(max, map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2]);
				max = Math.max(max, map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2]);
				max = Math.max(max, map[i][j+2] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2]);
				//z
				max = Math.max(max, map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1]);
				max = Math.max(max, map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+2][j]);
				max = Math.max(max, map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2]);
				max = Math.max(max, map[i+1][j] + map[i][j+1] + map[i+1][j+1] + map[i][j+2]);
			}
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
}
