import java.io.*;
import java.util.*;

public class Main_1074_Z_고진석 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for(int mid = (int)Math.pow(2, N - 1) ; mid >= 1 ; mid /= 2) {
			if(r >= mid) {
				r -= mid;
				ans += mid * mid * 2;
			}
			if(c >= mid) {
				c -= mid;
				ans += mid * mid;
			}
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
