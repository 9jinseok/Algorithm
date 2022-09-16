import java.io.*;
import java.util.*;

public class Main_1541_잃어버린괄호_고진석 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(),"-");
		int ans = 0;
		
		StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
		while(st2.hasMoreTokens())
			ans += Integer.parseInt(st2.nextToken());
		
		while(st.hasMoreTokens()){
			st2 = new StringTokenizer(st.nextToken(), "+");
			while(st2.hasMoreTokens())
				ans -= Integer.parseInt(st2.nextToken());
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}