import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_11727_2xn타일링2 {

    static int N;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i <= N ; i++){
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }

        bw.write(dp[N] +  "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
