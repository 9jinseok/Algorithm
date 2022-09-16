import java.io.*;
import java.util.*;

public class Main_3040_백설공주와일곱난쟁이_고진석 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = 9;
		int[] arr = new int[N];
		int sum = 0;
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		
		for(int i = 0 ; i < N - 1 ; i++)
			for(int j = i + 1 ; j < N ; j++)
				if(sum - arr[i] - arr[j] == 100)
					for(int x = 0 ; x < N ; x++)
						if(x != i && x != j)
							bw.write(arr[x] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}