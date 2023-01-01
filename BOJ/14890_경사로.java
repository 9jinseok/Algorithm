import java.io.*;
import java.util.*;

public class Main_14890_경사로 {
	static int N, L;
	static int[][] map;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int res = 0;
		
		for(int i = 0 ; i < N ; i++) {
			int prev = map[i][0];
			int cnt = 1;
			boolean chk = false, fail = false;
			for(int j = 1 ; j < N ; j++) {
				if(prev == map[i][j])
					cnt++;
				else {
					if(chk) {
						fail = true;
						break;
					}
					if(prev - map[i][j] == 1) {
						chk = true;
						prev = map[i][j];
						cnt = 1;
					}
					else if(prev - map[i][j] == -1) {
						if(cnt < L) {
							fail = true;
							break;
						}
						prev = map[i][j];
						cnt = 1;
					}
					else {
						fail = true;
						break;
					}
				}
				if(chk && cnt >= L) {
					cnt = 0;
					chk = false;
				}
			}
			if(!fail && !chk)
				res++;
			
			prev = map[0][i];
			cnt = 1;
			chk = false;
			fail = false;
			for(int j = 1 ; j < N ; j++) {
				if(prev == map[j][i])
					cnt++;
				else {
					if(chk) {
						fail = true;
						break;
					}
					if(prev - map[j][i] == 1) {
						chk = true;
						prev = map[j][i];
						cnt = 1;
					}
					else if(prev - map[j][i] == -1) {
						if(cnt < L) {
							fail = true;
							break;
						}
						prev = map[j][i];
						cnt = 1;
					}
					else {
						fail = true;
						break;
					}
				}
				if(chk && cnt >= L) {
					cnt = 0;
					chk = false;
				}
			}
			if(!fail && !chk)
				res++;
		}
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
}
