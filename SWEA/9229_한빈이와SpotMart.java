import java.util.*;
import java.io.*;

public class Solution_9229_한빈이와SpotMart_고진석 {
	static int N, M;
	static int max;
	static Integer[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
    	int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
	        arr = new Integer[N];
	        st = new StringTokenizer(br.readLine());
	        for(int i = 0 ; i < N ; i++)
	        	arr[i] = Integer.parseInt(st.nextToken());
	        Arrays.sort(arr, Collections.reverseOrder());
	        
	        max = -1;
	        for(int i = 0 ; i < N - 1 ; i++)
	        	max = Math.max(max, check(i + 1, arr[i]));
	        
	        bw.write("#" + t + " " + max + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}
	
	public static int check(int start, int weight) {
		for(int i = start ; i < N ; i++)
			if(arr[i] + weight <= M)
				return arr[i] + weight;
		return -1;
	}
}
