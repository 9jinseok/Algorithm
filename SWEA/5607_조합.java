import java.io.*;
import java.util.*;

public class Solution_5607_조합_고진석 {
	static int N, R;
	static final long MOD = 1234567891;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		long[] factorial = new long[1000001];
        factorial[0] = 1;
        for(int i = 1; i <= 1000000; i++){
            factorial[i] = (i * factorial[i-1]) % MOD;
        }
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			long ans = (factorial[N] * pow( (factorial[R]*factorial[N-R]) % MOD, MOD - 2)) % MOD;
			bw.write("#" + t + " " + ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static long pow(long a, long b){
        if(b == 0)
            return 1;
        long ans = pow(a, b / 2);
        long next = (ans * ans) % MOD;
        if(b % 2 == 0)
            return next;
        else
            return (next * a) % MOD;
    }
}