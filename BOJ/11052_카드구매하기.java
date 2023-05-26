import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052_카드구매하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];

        for(int i = 1 ; i <= N ; i++){
            for(int j = 0 ; j < i ; j++)
                dp[i] = Math.max(dp[i], dp[j] + arr[i - j]);
        }

        System.out.println(dp[N]);
        br.close();
    }

}
