import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1699_제곱수의합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3 ; i <= N ; i++){
            for(int j = (int)Math.sqrt(i) ; j >= 1 ; j--){
                if(dp[i - j * j] + 1 < dp[i])
                    dp[i] = dp[i - j * j] + 1;
            }
        }

        System.out.println(dp[N]);
        br.close();
    }
}
