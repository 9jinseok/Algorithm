import java.io.*;
import java.util.*;

public class Main_2630_색종이만들기_고진석 {
	
	static int w = 0, b = 0;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		chk(map, 0, N, 0, N);
		
		bw.write(w + "\n" + b + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void chk(int[][] map, int x1, int x2, int y1, int y2) {
		int start = map[x1][y1];
		for(int i = x1 ; i < x2 ; i++) 
			for(int j = y1 ; j < y2 ; j++)
				if(start != map[i][j]) {
					int midX = (x1 + x2) / 2;
					int midY = (y1 + y2) / 2;
					chk(map, x1, midX, y1, midY);
					chk(map, x1, midX, midY, y2);
					chk(map, midX, x2, y1, midY);
					chk(map, midX, x2, midY, y2);
					return;
				}
		if(start == 1)
			b++;
		else
			w++;
	}
	
}