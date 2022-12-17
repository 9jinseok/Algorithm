import java.io.*;
import java.util.*;

class Main_2458_키순서_고진석 {
	
	static int N, M;
	static int[][] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new int[N][N];
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			dist[Integer.parseInt(st.nextToken())- 1][Integer.parseInt(st.nextToken())- 1] = 1;
		}
		
		for(int k = 0 ; k < N ; k++)
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j < N ; j++)
					if(dist[i][k] == 1 && dist[k][j] == 1)
						dist[i][j] = 1;
		
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			boolean chk = true;
			for(int j = 0 ; j < N ; j++) {
				if(i == j)
					continue;
				if(dist[i][j] == 0 && dist[j][i] == 0) {
					chk = false;
					break;
				}
			}
			if(chk)
				res++;
		}
		
		bw.write(res + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}