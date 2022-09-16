import java.util.*;
import java.io.*;

public class Solution_1225_암호생성기_고진석 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Queue<Integer> q = new ArrayDeque<>(); 
        
        for(int t = 1 ; t <= 10 ; t++) {
        	int T = Integer.parseInt(br.readLine());
	        st = new StringTokenizer(br.readLine());
	        
	        q.clear();
	        int cnt = 0;
	        
	        for(int i = 0 ; i < 8 ; i++)
	        	q.offer(Integer.parseInt(st.nextToken()));
	        

	        while(true) {
	        	int tmp = q.poll();
	        	tmp -= (cnt++ % 5 + 1);
	        	if(tmp <= 0) {
	        		q.offer(0);
	        		break;
	        	}
	        	q.offer(tmp);
	        }
	        
	        bw.write("#" + T);
	        for(int i = 0 ; i < 8 ; i++)
	        	bw.write(" " + q.poll());
	        bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}
}
