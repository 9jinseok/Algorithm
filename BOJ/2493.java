import java.io.*;
import java.util.*;

public class Main_2493_탑_고진석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[]{Integer.MAX_VALUE, 0});
		for(int i = 1 ; i <= N ; i++) {
			int height =Integer.parseInt(st.nextToken());
			while(height > stack.peek()[0])
				stack.pop();
			
			bw.write(stack.peek()[1] + " ");
			stack.push(new int[]{height, i});
			
		}
		
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}

}