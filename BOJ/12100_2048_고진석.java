import java.io.*;
import java.util.*;

class Main_12100_2048_고진석{
	static int N;
	static int[][] map;
	static int[] order = new int[5];
	static int res = 0;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		perm(0);
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void perm(int depth) {
		if(depth == 5) {
			move();
		}
		else {
			for(int i = 0 ; i < 4 ; i++) {
				order[depth] = i;
				perm(depth + 1);
			}
		}
	}
	
	public static void move() {
		int[][] copyMap = map;
		
		for(int k = 0 ; k < 5 ; k++) {
			int[][] newMap = new int[N][N];
			switch(order[k]) {
				case 0:
					for(int i = 0 ; i < N ; i++) {
						int prev = -1;
						int idx = 0;
						for(int j = 0 ; j < N ; j++) {
							if(copyMap[j][i] == 0)
								continue;
							if(prev == copyMap[j][i]) {
								newMap[idx][i] = prev * 2;
								prev = -1;
								idx++;
							}
							else{
								if(prev > 0) {
									newMap[idx][i] = prev;
									idx++;
								}
								prev = copyMap[j][i];
							}
						}
						if(prev > 0) {
							newMap[idx][i] = prev;
							idx++;
						}
					}
					break;
				case 1:
					for(int i = 0 ; i < N ; i++) {
						int prev = -1;
						int idx = N - 1;
						for(int j = N - 1 ; j >= 0 ; j--) {
							if(copyMap[j][i] == 0)
								continue;
							if(prev == copyMap[j][i]) {
								newMap[idx][i] = prev * 2;
								prev = -1;
								idx--;
							}
							else{
								if(prev > 0) {
									newMap[idx][i] = prev;
									idx--;
								}
								prev = copyMap[j][i];
							}
						}
						if(prev > 0) {
							newMap[idx][i] = prev;
							idx--;
						}
					}
					break;
				case 2:
					for(int i = 0 ; i < N ; i++) {
						int prev = -1;
						int idx = 0;
						for(int j = 0 ; j < N ; j++) {
							if(copyMap[i][j] == 0)
								continue;
							if(prev == copyMap[i][j]) {
								newMap[i][idx] = prev * 2;
								prev = -1;
								idx++;
							}
							else{
								if(prev > 0) {
									newMap[i][idx] = prev;
									idx++;
								}
								prev = copyMap[i][j];
							}
						}
						if(prev > 0) {
							newMap[i][idx] = prev;
							idx++;
						}
					}
					break;
				case 3:
					for(int i = 0 ; i < N ; i++) {
						int prev = -1;
						int idx = N - 1;
						for(int j = N - 1 ; j >= 0 ; j--) {
							if(copyMap[i][j] == 0)
								continue;
							if(prev == copyMap[i][j]) {
								newMap[i][idx] = prev * 2;
								prev = -1;
								idx--;
							}
							else{
								if(prev > 0) {
									newMap[i][idx] = prev;
									idx--;
								}
								prev = copyMap[i][j];
							}
						}
						if(prev > 0) {
							newMap[i][idx] = prev;
							idx--;
						}
					}
					break;
			}
			copyMap = newMap;
		}
		
		res = Math.max(calc(copyMap), res);
	}
	
	public static int calc(int[][] map) {
		int max = 0;
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < N ; j++)
				max = Math.max(max, map[i][j]);
		return max;
	}
}
