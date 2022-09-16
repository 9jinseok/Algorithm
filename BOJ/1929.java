import java.io.*;
import java.util.*;

public class Main_1929_소수구하기_고진석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	boolean[] nums = new boolean[1_000_000 + 1];
    	Arrays.fill(nums, true);
    	nums[0] = nums[1] = false;
    	
    	for(int i = 2 ; i <= 1000 ; i++) {
    		if(nums[i]) {
    			for(int j = i * i ; j <= 1_000_000 ; j += i)
    				nums[j] = false;
    		}
    	}
    	
    	for(int i = N ; i <= M ; i++) {
    		if(nums[i])
    			bw.write(i + "\n");
    	}
    	
    	bw.flush();
    	bw.close();
    	br.close();
	}

}
