import java.util.*;
import java.io.*;

public class Solution_1979_어디에단어가들어갈수있을까 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for(int t = 0 ; t < T ; t++) {
	        st = new StringTokenizer(br.readLine());
	        int N = Integer.parseInt(st.nextToken());
	        int K = Integer.parseInt(st.nextToken());
	        
	        int[][] map = new int[N][N];
	        for(int i = 0 ; i < N ; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	for(int j = 0 ; j < N ; j++)
	        		map[i][j] = Integer.parseInt(st.nextToken());
	        }
	        int ans = 0;
	        
	        for(int i = 0 ; i < N ; i++)
		        for(int j = 0 ; j <= N - K ; j++) {
		        	if(j != 0 && map[i][j-1] == 1)
		        		continue;
		        	boolean chk = true;
		        	for(int l = 0 ; l < K ; l++) {
		        		if(map[i][j+l] == 0) {
		        			chk = false;
		        			break;
		        		}
		        	}
		        	if(chk && (j+K >= N || map[i][j+K] == 0))
		        		ans += 1;
		        }
	        
	        for(int i = 0 ; i < N ; i++)
		        for(int j = 0 ; j <= N - K ; j++) {
		        	if(j != 0 && map[j-1][i] == 1)
		        		continue;
		        	boolean chk = true;
		        	for(int l = 0 ; l < K ; l++) {
		        		if(map[j+l][i] == 0) {
		        			chk = false;
		        			break;
		        		}
		        	}
		        	if(chk && (j+K >= N || map[j+K][i] == 0))
		        		ans += 1;
		        }
	        
	        bw.write("#" + (t+1) + " " + ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}
}