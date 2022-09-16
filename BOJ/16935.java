import java.io.*;
import java.util.*;

public class Main_16935_배열돌리기3_고진석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[100][100];
		int[][] res = new int[100][100];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int r = 0 ; r < R ; r++) {
			int cmd = Integer.parseInt(st.nextToken());
			switch(cmd) {
				case 1:
					for(int i = 0 ; i < N ; i++)
						for(int j = 0 ; j < M ; j++)
							res[i][j] = map[N - 1 - i][j];
					break;
				case 2:
					for(int i = 0 ; i < N ; i++)
						for(int j = 0 ; j < M ; j++)
							res[i][j] = map[i][M - 1 - j];
					break;
				case 3:
					int tmp = M;
					M = N;
					N = tmp;
					for(int i = 0 ; i < N ; i++)
						for(int j = 0 ; j < M ; j++)
							res[i][j] = map[M - 1 - j][i];
					break;
				case 4:
					tmp = M;
					M = N;
					N = tmp;
					for(int i = 0 ; i < N ; i++)
						for(int j = 0 ; j < M ; j++)
							res[i][j] = map[j][N - 1 - i];
					break;
				case 5:
					int n = N/2;
					int m = M/2;
					for(int i = 0 ; i < n ; i++)
						for(int j = 0 ; j < m ; j++)
							res[i][j] = map[i + n][j];
					for(int i = 0 ; i < n ; i++)
						for(int j = m ; j < M ; j++)
							res[i][j] = map[i][j - m];
					for(int i = n ; i < N ; i++)
						for(int j = 0 ; j < m ; j++)
							res[i][j] = map[i][j + m];
					for(int i = n ; i < N ; i++)
						for(int j = m ; j < M ; j++)
							res[i][j] = map[i - n][j];
					break;
				case 6:
					n = N/2;
					m = M/2;
					for(int i = 0 ; i < n ; i++)
						for(int j = 0 ; j < m ; j++)
							res[i][j] = map[i][j + m];
					for(int i = 0 ; i < n ; i++)
						for(int j = m ; j < M ; j++)
							res[i][j] = map[i + n][j];
					for(int i = n ; i < N ; i++)
						for(int j = 0 ; j < m ; j++)
							res[i][j] = map[i - n][j];
					for(int i = n ; i < N ; i++)
						for(int j = m ; j < M ; j++)
							res[i][j] = map[i][j - m];
					break;
			}
			for(int i = 0; i < N; i++)
				System.arraycopy(res[i], 0, map[i], 0, M);
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
