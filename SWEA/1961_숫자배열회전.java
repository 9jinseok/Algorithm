import java.util.*;
import java.io.*;

public class Solution_1961_숫자배열회전 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for(int t = 0 ; t < T ; t++) {
	        st = new StringTokenizer(br.readLine());
	        int N = Integer.parseInt(st.nextToken());
	        
	        int[][] map = new int[N][N];
	        for(int i = 0 ; i < N ; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	for(int j = 0 ; j < N ; j++)
	        		map[i][j] = Integer.parseInt(st.nextToken());
	        }
	        bw.write("#" + (t+1) + "\n");
	        for(int i = 0 ; i < N ; i++) {
	        	for(int j = 0 ; j < N ; j++) {
	        		bw.write(String.valueOf(map[N-j-1][i]));
	        	}
	        	bw.write(" ");
	        	for(int j = 0 ; j < N ; j++) {
	        		bw.write(String.valueOf(map[N-i-1][N-j-1]));
	        	}
	        	bw.write(" ");
	        	for(int j = 0 ; j < N ; j++) {
	        		bw.write(String.valueOf(map[j][N-i-1]));
	        	}
	        	bw.write("\n");
	        }
        }
        bw.flush();
        bw.close();
        br.close();
	}
}