import java.util.*;
import java.io.*;

public class Solution_1228_암호문1_고진석 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
    	List<Integer> list = new ArrayList<>();
        
        for(int t = 1 ; t <= 10 ; t++) {
        	int N = Integer.parseInt(br.readLine());
	        st = new StringTokenizer(br.readLine());
	        
	        list.clear();
	        for(int i = 0 ; i < N ; i++)
	        	list.add(Integer.parseInt(st.nextToken()));
	        
	        int M = Integer.parseInt(br.readLine());
	        st = new StringTokenizer(br.readLine());
	        for(int i = 0 ; i < M ; i++) {
	        	if(!st.nextToken().equals("I"))
	        		break;
	        	int k = Integer.parseInt(st.nextToken());
	        	int n = Integer.parseInt(st.nextToken());
	        	for(int j = 0 ; j < n ; j++)
	        		list.add(k++, Integer.parseInt(st.nextToken()));
	        }
	        
	        bw.write("#" + t);
	        for(int i = 0 ; i < 10 ; i++)
	        	bw.write(" " + list.get(i));
	        bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}
}
