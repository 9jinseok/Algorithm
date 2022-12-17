import java.io.*;
import java.util.*;

class Main_9205_맥주마시면서걸어가기_고진석 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0 ; t < T ; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] xy = new int[n+2][2];
			for(int i = 0 ; i < n + 2 ; i++) {
				st = new StringTokenizer(br.readLine());
				xy[i][0] = Integer.parseInt(st.nextToken());
				xy[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dist = new int[n+2][n+2];
			
			for(int i = 0 ; i < n + 2 ; i++)
				for(int j = 0 ; j < n + 2 ; j++) {
					if(calcDist(xy[i][0],xy[i][1],xy[j][0],xy[j][1]) > 1000)
						dist[i][j] = 1;
					else
						dist[i][j] = 0;
				}
			
			for(int i = 0 ; i < n + 2 ; i++)
				for(int j = 0 ; j < n + 2 ; j++)
					for(int k = 0 ; k < n + 2; k++)
						if(dist[j][i] == 0 && dist[i][k] == 0)
							dist[j][k] = 0;
			
			if(dist[0][n + 1] == 0)		
				bw.write("happy\n");
			else
				bw.write("sad\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int calcDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}