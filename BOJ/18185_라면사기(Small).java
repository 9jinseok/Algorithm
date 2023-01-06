import java.io.*;
import java.util.*;

public class Main_18185_라면사기 {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int res = 0;
		for(int i = 0 ; i < N ; i++) {
			if(i < N - 2) {
				while(arr[i] > 0 && arr[i + 1] > 0 && arr[i + 1] > arr[i + 2]) {
					arr[i]--;
					arr[i + 1]--;
					res += 5;
				}
				while(arr[i] > 0 && arr[i + 1] > 0 && arr[i + 2] > 0) {
					arr[i]--;
					arr[i + 1]--;
					arr[i + 2]--;
					res += 7;
				}
			}
			if(i < N - 1) {
				while(arr[i] > 0 && arr[i + 1] > 0) {
					arr[i]--;
					arr[i + 1]--;
					res += 5;
				}
			}
			res += arr[i] * 3;
		}
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
