import java.io.*;

public class Main_1094_막대기_고진석 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int X = Integer.parseInt(br.readLine());
		
		int mod = 64;
		int cnt = 0;
		while(X > 0) {
			if(X >= mod) {
				cnt++;
				X -= mod;
			}
			mod /= 2;
		}
		
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
