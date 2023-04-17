import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭 {
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][2];
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1 ; i <= N ; i++){
            for (int w = 1 ; w <= K ; w++){
                if (arr[i][0] <= w){ // 최대 무게를 하나씩 올려가면서 계산
                    if ((arr[i][1] + dp[i - 1][w - arr[i][0]]) > dp[i-1][w]) // 이전 최대가치를 사용하는 것보다 이전걸 빼고 현재물건을 넣는게 더 좋다면 넣어주자
                        dp[i][w] = arr[i][1] + dp[i-1][w-arr[i][0]];
                    else dp[i][w] = dp[i-1][w]; // 아니라면 이전가치를  그대로 사용
                }
                else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        System.out.println(dp[N][K]);
        br.close();
    }
}
