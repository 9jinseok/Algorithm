import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_2156_포도주시식 {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N][3];
        dp[0][1] = arr[0];
        dp[0][2] = arr[0];
        if(N > 1){
            dp[1][0] = arr[0];
            dp[1][1] = arr[1];
            dp[1][2] = arr[0] + arr[1];
        }
        for(int i = 2 ; i < N ; i++){
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            dp[i][1] = dp[i - 1][0] + arr[i];
            dp[i][2] = dp[i - 1][1] + arr[i];
        }

        bw.write(Math.max(Math.max(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
