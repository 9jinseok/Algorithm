import java.io.*;
import java.util.*;

public class Main_20055_컨베이어벨트위의로봇 {
	static int N, K;
	static int[] negu;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		negu = new int[2 * N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < 2 * N ; i++)
			negu[i] = Integer.parseInt(st.nextToken());
		
		boolean[] robot = new boolean[N];
		int ol = 0, ne = N - 1;
		
		int turn;
		int k = 0;
		for(turn = 1 ; ; turn++) {
			ol = (ol + 2 * N - 1) % (2 * N);
			ne = (ne + 2 * N - 1) % (2 * N);
			for(int i = N - 2 ; i > 0 ; i--)
				robot[i] = robot[i - 1];
			robot[0] = false;
			robot[N - 1] = false;
			
			for(int i = N - 2 ; i >= 0 ; i--) {
				if(!robot[i])
					continue;
				if(!robot[i + 1] && negu[(ol + i + 1) % (2 * N)] > 0) {
					robot[i] = false;
					robot[i + 1] = true;
					if(--negu[(ol + i + 1) % (2 * N)] == 0)
						k++;
				}
			}
			robot[N - 1] = false;
			
			if(negu[ol] > 0) {
				robot[0] = true;
				if(--negu[ol] == 0)
					k++;
			}
			
			if(k >= K)
				break;
		}
		
		bw.write(turn + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
}
