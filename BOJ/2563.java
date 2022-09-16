import java.io.*;
import java.util.*;

public class Main_2563_색종이_고진석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[100][100];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j = 0 ; j < 10 ; j++)
				for(int k = 0 ; k < 10 ; k++)
					map[x + j][y + k]++;
		}
		
		int sum = 0;
		for(int j = 0 ; j < 100 ; j++)
			for(int k = 0 ; k < 100 ; k++)
				if(map[j][k] != 0)
					sum++;
		
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}