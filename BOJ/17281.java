import java.io.*;
import java.util.*;

public class Main_17281_야구_고진석 {
	static int N, ans = 0;
	static int[][] info;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		info = new int[N][9];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 9 ; j++)
				info[i][j] = Integer.parseInt(st.nextToken());
		}
		int[] order = new int[9];
		visited = new boolean[9];
		order[3] = 0;
		visited[0] = true;
		makeOrder(order, 0);
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void makeOrder(int[] order, int depth) {
		if(depth == 9) {
			int score = play(order);
			ans = Math.max(ans, score);
		}
		else {
			if(depth == 3)
				makeOrder(order, depth + 1);
			else {
				for(int i = 0 ; i < 9 ; i++) {
					if(visited[i])
						continue;
					visited[i] = true;
					order[depth] = i;
					makeOrder(order, depth + 1);
					visited[i] = false;
				}
			}
		}
	}
	
	public static int play(int[] order) {
		boolean[] runners = new boolean[3];
		int turn = 0;
		int outCnt = 0;
		int score = 0;
		for(int ining = 0 ; ining < N ; ining++) {
			outCnt = 0;
			Arrays.fill(runners, false);
			while(outCnt < 3) {
				switch(info[ining][order[turn]]) {
					case 0:
						outCnt++;
						break;
					case 1:
						if(runners[2])
							score++;
						runners[2] = runners[1];
						runners[1] = runners[0];
						runners[0] = true;
						break;
					case 2:
						if(runners[2])
							score++;
						if(runners[1])
							score++;
						runners[2] = runners[0];
						runners[1] = true;
						runners[0] = false;
						break;
					case 3:
						if(runners[2])
							score++;
						if(runners[1])
							score++;
						if(runners[0])
							score++;
						runners[2] = true;
						runners[1] = false;
						runners[0] = false;
						break;
					case 4:
						if(runners[2])
							score++;
						if(runners[1])
							score++;
						if(runners[0])
							score++;
						score++;
						Arrays.fill(runners, false);
						break;
				}
				turn = (turn + 1) % 9;
			}
		}
		return score;
	}
}
