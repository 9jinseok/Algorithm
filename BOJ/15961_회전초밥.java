import java.io.*;
import java.util.*;

class Main_15961_회전초밥_고진석 {
	
	static int N, d, k, c;
	static int[] table;
	static int[] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int res = 0;
		int total = 0;
		
		table = new int[N];
		cnt = new int[d + 1];
		cnt[c]++;
		total++;
		
		for(int i = 0 ; i < k ; i++) {
			table[i] = Integer.parseInt(br.readLine());
			if(cnt[table[i]] == 0)
				total++;
			cnt[table[i]]++;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(i + k < N)
				table[i + k] = Integer.parseInt(br.readLine());
			
			if(cnt[table[(i + k)%N]] == 0)
				total++;
			cnt[table[(i + k)%N]]++;
			
			cnt[table[i]]--;
			if(cnt[table[i]] == 0)
				total--;
			res = Math.max(total, res);
		}
		
		bw.write(res + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}