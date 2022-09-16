import java.io.*;

class 농작물수확하기
{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			int sum = 0;
			for(int i = 0 ; i < N ; i++) {
				String s = br.readLine();
				for(int j = 0 ; j < N ; j++) {
					arr[i][j] = s.charAt(j) - '0';
					sum += arr[i][j];
				}
			}
			int mid = N / 2;
			for(int i = 0 ; i < mid ; i++) {
				
				for(int j = i ; j < mid ; j++) {
					sum -= (arr[i][mid - 1 - j] + arr[i][mid + 1 + j]);
					sum -= (arr[N - 1 - i][mid - 1 - j] + arr[N - 1 - i][mid + 1 + j]);
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
}
