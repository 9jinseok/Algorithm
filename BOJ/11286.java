import java.io.*;
import java.util.*;

public class Main_11286_절댓값힙_고진석 {
	
	static int res = Integer.MAX_VALUE;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2))
					return o1 - o2;
				else
					return Math.abs(o1) - Math.abs(o2);
			}
		});
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			int cmd = Integer.parseInt(br.readLine());
			if(cmd != 0)
				pq.add(cmd);
			else if(pq.isEmpty())
				bw.write("0\n");
			else
				bw.write(pq.poll() + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}