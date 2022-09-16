import java.io.*;
import java.util.*;

public class Main_2839_설탕배달_고진석 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		while(N > 0) {
			if(N % 5 == 0) {
				ans += N / 5;
				break;
			}
			ans++;
			N -= 3;
		}
		
		if(N < 0)
			ans = -1;
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
