import java.io.*;
import java.util.*;

class Flatten
{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[100];
		for(int t = 1; t <= 10; t++) {
			int k = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 100 ; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0 ; i < k ; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}
			
			Arrays.sort(arr);
			
			System.out.println("#" + t + " " + (arr[99] - arr[0]));
		}
	}
}