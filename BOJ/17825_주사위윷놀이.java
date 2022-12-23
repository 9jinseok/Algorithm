import java.io.*;
import java.util.*;

class Main_17825_주사위윷놀이_고진석{
	static int[] dice = new int[10];
	static int[][] map = new int[33][3];
	static int[] order = new int[10];
	static int res = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int idx = 0;
		for(; idx <= 20 ; idx++) {
			map[idx] = new int[] {idx * 2, idx + 1, -1};
		}
		
		//21
		map[idx++] = new int[] {0, -1, -1};
		
		map[5][2] = 22;
		map[idx++] = new int[] {13, 23, -1};
		map[idx++] = new int[] {16, 24, -1};
		map[idx++] = new int[] {19, 30, -1};
		
		map[10][2] = 25;
		map[idx++] = new int[] {22, 26, -1};
		map[idx++] = new int[] {24, 30, -1};
		
		map[15][2] = 27;
		map[idx++] = new int[] {28, 28, -1};
		map[idx++] = new int[] {27, 29, -1};
		map[idx++] = new int[] {26, 30, -1};
		
		map[idx++] = new int[] {25, 31, -1};
		map[idx++] = new int[] {30, 32, -1};
		map[idx++] = new int[] {35, 20, -1};
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < 10 ; i++)
			dice[i] = Integer.parseInt(st.nextToken());
		
		perm(0);
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void perm(int depth) {
		if(depth == 10) {
			res = Math.max(res, calc());
		}
		else {
			for(int i = 0 ; i < 4 ; i++) {
				order[depth] = i;
				perm(depth + 1);
			}
		}
	}
	
	public static int calc() {
		int score = 0;
		int[] horse = new int[] {0, 0, 0, 0};
		
		for(int i = 0 ; i < 10 ; i++) {
			//움직일 말 : order[i]
			//움직일 칸 : dice[i]
			
			int loc = horse[order[i]];
			if(loc == 21)
				return 0;
			for(int k = 0 ; k < dice[i] ; k++) {
				if(loc == 21)
					break;
				if(k == 0 && map[loc][2] != -1)
					loc = map[loc][2];
				else
					loc = map[loc][1];
			}
			for(int j = 0 ; j < 4 ; j++)
				if(loc != 21 && horse[j] == loc)
					return 0;
			
			horse[order[i]] = loc;
			score += map[loc][0];
		}
		
		return score;
	}
}
