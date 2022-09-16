import java.io.*;
import java.util.*;

public class Main_1759_암호만들기_고진석 {
	static int L, C;
	static char[] chars;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		chars = new char[C];
		for(int i = 0 ; i < C ; i++)
			chars[i] = st.nextToken().charAt(0);
		
		Arrays.sort(chars);
		dfs(0, 0, 0, 0);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int depth, int start, int visited, int cnt) throws Exception {
		if(depth == L && cnt >= 1 && depth - cnt >= 2) {
			for(int i = 0 ; i < C ; i++)
				if((visited & 1 << i) != 0)
					bw.write(chars[i]);
			bw.write("\n");
		}
		else {
			for(int i = start ; i < C ; i++) {
				char c = chars[i];
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
					dfs(depth + 1, i + 1, visited | 1 << i, cnt + 1);
				else
					dfs(depth + 1, i + 1, visited | 1 << i, cnt);
			}
		}
	}
}
