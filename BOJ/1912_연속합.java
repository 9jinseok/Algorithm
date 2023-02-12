import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_1912_연속합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[N];
        dp[0] = arr[0];
        int max = dp[0];
        for(int i = 1 ; i < N ; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            if (max < dp[i])
                max = dp[i];
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
