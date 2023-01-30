import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_9095_123더하기 {
    static int T;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        dp[0] = 1;
        for(int i = 1 ; i <= 10 ; i++){
            dp[i] += dp[i - 1];
            if(i >= 2)
                dp[i] += dp[i - 2];
            if(i >= 3)
                dp[i] += dp[i - 3];
        }

        for(int t = 0 ; t < T ; t++){
            bw.write(dp[Integer.parseInt(br.readLine())] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
