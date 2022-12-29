import java.io.*;
import java.util.*;

public class Main_14891_톱니바퀴 {
	static int N;
	static int[][] topni;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		topni = new int[4][8];
		
		for(int i = 0 ; i < 4 ; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0 ; j < 8 ; j++)
				topni[i][j] = input[j] - '0';
		}
		
		N = Integer.parseInt(br.readLine());
		
		int n;
		int[] dir = new int[4];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			dir[n - 1] = Integer.parseInt(st.nextToken());
			
			for(int j = n - 2 ; j >= 0 ; j--) {
				if(topni[j][2] != topni[j+1][6])
					dir[j] = - dir[j + 1];
				else
					dir[j] = 0;
			}
			
			for(int j = n ; j < 4 ; j++) {
				if(topni[j][6] != topni[j-1][2])
					dir[j] = - dir[j - 1];
				else
					dir[j] = 0;
			}
			
			run(dir);
		}
		
		int res = 0;
		
		for(int i = 0 ; i < 4 ; i++) {
			if(topni[i][0] == 1)
				res += 1 << i;
		}
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void run(int[] dir) {
		for(int i = 0 ; i < 4 ; i++) {
			if(dir[i] == 0)
				continue;
			if(dir[i] == 1) {
				int tmp = topni[i][7];
				for(int j = 7 ; j > 0 ; j--)
					topni[i][j] = topni[i][j - 1];
				topni[i][0] = tmp;
			}
			else {
				int tmp = topni[i][0];
				for(int j = 0 ; j < 7 ; j++)
					topni[i][j] = topni[i][j + 1];
				topni[i][7] = tmp;
			}
		}
	}
}
