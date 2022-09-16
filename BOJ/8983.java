import java.io.*;
import java.util.*;

public class Main_8983_사냥꾼_고진석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[M];
		for(int i = 0 ; i < M ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int ans = 0;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(y > L)
				continue;
			
			int high = M - 1, low = 0;
			int mid = 0;
			boolean chk = false;
			while(high >= low) {
				mid = (high + low) / 2;
				if(arr[mid] == x) {
					chk = true;
					break;
				}
				else if(arr[mid] > x)
					high = mid - 1;
				else
					low = mid + 1;
			}
			if(chk)
				ans++;
			else {
				int tmp = y;
				if(high < 0)
					tmp += Math.abs(arr[low] - x);
				else if(low > M - 1)
					tmp += Math.abs(arr[high] - x);
				else
					tmp += Math.min(Math.abs(arr[high] - x), Math.abs(arr[low] - x));
				if(tmp <= L)
					ans++;
			}
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
