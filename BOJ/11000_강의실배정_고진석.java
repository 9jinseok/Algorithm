import java.io.*;
import java.util.*;

public class Main_11000_강의실배정_고진석 {
	static int N;
	static int[][] arr;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0][1]);
        
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i][0]) {
                pq.poll();
            }
            pq.offer(arr[i][1]);
        }

        bw.write(pq.size() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
}