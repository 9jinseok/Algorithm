import java.util.Scanner;

class Solution_1959_두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0 ; t < T ; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];
			for(int i = 0 ; i < N ; i++)
				A[i] = sc.nextInt();
			for(int i = 0 ; i < M ; i++)
				B[i] = sc.nextInt();
			
			if(N == M) {
				int sum = 0;
				for(int i = 0 ; i < N ; i++)
					sum += A[i] * B[i];
				System.out.println("#" + (t + 1) + " " + sum);
			}
			else if(N < M) {
				int max = Integer.MIN_VALUE;
				for(int i = 0 ; i <= M - N ; i++) {
					int sum = 0;
					for(int j = 0 ; j < N ; j++)
						sum += A[j] * B[j + i];
					max = Math.max(max, sum);
				}
				System.out.println("#" + (t + 1) + " " + max);
			}
			else {
				int max = Integer.MIN_VALUE;
				for(int i = 0 ; i <= N - M ; i++) {
					int sum = 0;
					for(int j = 0 ; j < M ; j++)
						sum += A[j + i] * B[j];
					max = Math.max(max, sum);
				}
				System.out.println("#" + (t + 1) + " " + max);
			}
			
		}
	}
}