import java.io.*;
import java.util.*;

public class Main_12891_DNA비밀번호_고진석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken()); 
		int P = Integer.parseInt(st.nextToken());
		
		char[] s = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[4];
		for(int i = 0 ; i < 4 ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int[] cnt = new int[20];
		int ans = 0;
		
		for(int i = 0 ; i < P ; i++)
			cnt[s[i] - 'A']++;
		if(cnt[0] >= arr[0] && cnt[2] >= arr[1] && cnt[6] >= arr[2] && cnt[19] >= arr[3])
			ans++;
		
		for(int i = 0 ; i < S - P ; i++) {
			cnt[s[i] - 'A']--;
			cnt[s[i + P] - 'A']++;
			if(cnt[0] >= arr[0] && cnt[2] >= arr[1] && cnt[6] >= arr[2] && cnt[19] >= arr[3])
				ans++;
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}