import java.util.*;
import java.io.*;

public class Solution_1974_스도쿠검증 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for(int t = 0 ; t < T ; t++) {
	        int N = 9;
	        
	        int[][] map = new int[N][N];
	        for(int i = 0 ; i < N ; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	for(int j = 0 ; j < N ; j++)
	        		map[i][j] = Integer.parseInt(st.nextToken());
	        }
	        
	        int[] chk = new int[9];
	        
	        //가로
	        boolean ck = true;
	        for(int i = 0 ; i < N ; i++) {
	        	for(int j = 0 ; j < N ; j++)
	        		chk[map[i][j]-1] += 1;
	        	for(int j = 0 ; j < N - 1 ; j++)
	        		if(chk[j] != chk[j+1]) {
	        			ck = false;
	        			break;
	        		}
	        	if(!ck)
	        		break;
	        }
	        if(!ck) {
	        	bw.write("#" + (t+1) + " 0\n");
	        	continue;
	        }
	        
	        //세로
	        ck = true;
	        for(int i = 0 ; i < N ; i++) {
	        	for(int j = 0 ; j < N ; j++)
	        		chk[map[j][i]-1] += 1;
	        	for(int j = 0 ; j < N - 1 ; j++)
	        		if(chk[j] != chk[j+1]) {
	        			ck = false;
	        			break;
	        		}
	        	if(!ck)
	        		break;
	        }
	        if(!ck) {
	        	bw.write("#" + (t+1) + " 0\n");
	        	continue;
	        }
	        //네모
	        ck = true;
	        for(int i = 0 ; i < N ; i++) {
	        	int x = (i/3) * 3;
	        	int y = (i%3) * 3;
	        	for(int j = 0 ; j < 3 ; j++)
	        		for(int k = 0 ; k < 3 ; k++)
	        			chk[map[x+j][y+k]-1] += 1;
	        	for(int j = 0 ; j < N - 1 ; j++)
	        		if(chk[j] != chk[j+1]) {
	        			ck = false;
	        			break;
	        		}
	        	if(!ck)
	        		break;
	        }
	        if(!ck) {
	        	bw.write("#" + (t+1) + " 0\n");
	        	continue;
	        }
	        
	        bw.write("#" + (t+1) + " 1\n");

        }
        bw.flush();
        bw.close();
        br.close();

	}
}