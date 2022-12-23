import java.io.*;
import java.util.*;

public class Main_13904_과제_고진석 {
	static int N;
	static int[][] arr;
	static int res = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][2];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int idx = 0;
		for(int i = arr[0][0] ; i > 0 ; i--) {
			while(arr[idx][0] == i) {
				pq.add(arr[idx][1]);
				idx++;
			}
			if(!pq.isEmpty())
				res += pq.poll();
		}
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
}