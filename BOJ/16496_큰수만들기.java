import java.io.*;
import java.util.*;

public class Main_16496_큰수만들기_고진석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		String[] nums = new String[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++)
			nums[i] = st.nextToken();

		Comparator<String> myComparator = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String startS1 = s1 + s2;
				String startS2 = s2 + s1;

				return startS2.compareTo(startS1);
			}
		};

		Arrays.sort(nums, myComparator);
		StringBuilder sb = new StringBuilder();
		for(String s : nums)
			sb.append(s);
		while(sb.length() > 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		bw.write(sb.toString() + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
