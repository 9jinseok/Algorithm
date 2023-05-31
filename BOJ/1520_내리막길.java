import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520_내리막길 {

    static int M, N;
    static int[][] map, dp;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 1;
        System.out.println(getPathCount(M - 1, N - 1));
        br.close();
    }

    public static boolean isIn(int x, int y){
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    public static int getPathCount(int x, int y){
        int count = 0;
        for(int d = 0 ; d < 4 ; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(isIn(nx, ny) && map[x][y] < map[nx][ny]){
                if(dp[nx][ny] != -1)
                    count += dp[nx][ny];
                else
                    count += getPathCount(nx, ny);
            }
        }

        dp[x][y] = count;
        return count;
    }
}
