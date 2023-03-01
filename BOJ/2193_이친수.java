import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2193_이친수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        long[][] dp = new long[91][2];

        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i = 2 ; i <= 90 ; i++){
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }
        int N = Integer.parseInt(br.readLine());
        bw.write((dp[N][0] + dp[N][1]) + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

}