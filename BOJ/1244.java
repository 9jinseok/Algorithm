import java.io.*;
import java.util.*;

public class 스위치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		int[][] sArr = new int[M][2];
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			sArr[i][0] = Integer.parseInt(st.nextToken());
			sArr[i][1] = Integer.parseInt(st.nextToken());
		}	
		
		for(int i = 0 ; i < M ; i++) {
			int num = sArr[i][1];
			if(sArr[i][0] == 1) {
				for(int j = num ; j <= N ; j += num) {
					if(arr[j - 1] == 0)
						arr[j - 1] = 1;
					else
						arr[j - 1] = 0;
				}
			}
			else {
				int start = num - 2, end = num;
				while(start >= 0 && end < N) {
					if(arr[start] == arr[end]) {
						start--;
						end++;
						continue;
					}
					else
						break;
				}
				for(int j = start + 1 ; j < end ; j++) {
					if(arr[j] == 0)
						arr[j] = 1;
					else
						arr[j] = 0;
				}
			}
		}
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			if(cnt >= 20) {
				bw.write("\n");
				cnt = 0;
			}
			bw.write(arr[i] + " ");
			cnt++;
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
