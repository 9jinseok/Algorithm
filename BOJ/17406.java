import java.io.*;
import java.util.*;

public class Main_17406_배열돌리기4_고진석 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] cmd;
	static int res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		cmd = new int[K][3];
		int[] arr = new int[K];
		for(int i = 0 ; i < K ; i++) {
			arr[i] = i;
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 3 ; j++)
				cmd[i][j] = Integer.parseInt(st.nextToken());
		}
		
		perm(0, arr);
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int calc(int[][] map) {
		int res = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < map.length ; i++) {
			int sum = 0;
			for(int num : map[i])
				sum += num;
			res = Math.min(res, sum);
		}
		
		return res;
	}
	
	public static void rotate(int[][] map, int r, int c, int s) {
		int startR = r - s;
		int endR = r + s;
		int startC = c - s;
		int endC = c + s;
		for(int d = 0 ; d < s ; d++) {
			int tmp = map[endR - d][endC - d];
			for(int i = endR - d ; i > startR + d ; i--)
				map[i][endC - d] = map[i - 1][endC - d];
			for(int i = endC - d ; i > startC + d ; i--)
				map[startR + d][i] = map[startR + d][i - 1];
			for(int i = startR + d ; i < endR - d ; i++)
				map[i][startC + d] = map[i + 1][startC + d];
			for(int i = startC + d ; i < endC - d ; i++)
				map[endR - d][i] = map[endR - d][i + 1];
			map[endR - d][endC - d - 1] = tmp;
		}
	}
	
	public static void perm(int start, int[] arr) {
		if(start == arr.length) {
			int[][] tmpMap = new int[N][M];
			for(int i = 0 ; i < N ; i++)
				System.arraycopy(map[i], 0, tmpMap[i], 0, M);
			for(int i = 0 ; i < arr.length ; i++) {
				rotate(tmpMap, cmd[arr[i]][0] - 1, cmd[arr[i]][1] - 1, cmd[arr[i]][2]);
			}
			res = Math.min(res, calc(tmpMap));
		}
		else {
			for(int i = start ; i < arr.length ; i++) {
				swap(arr, i, start);
				perm(start + 1, arr);
				swap(arr, i, start);
			}
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
		return;
	}
}