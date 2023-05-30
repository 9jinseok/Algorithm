import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {

    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        for(int k = 0 ; k <= 100 ; k++){
            boolean[][] visited = new boolean[N][N];
            for(int i = 0 ; i < N ; i++)
                for(int j = 0 ; j < N ; j++){
                    if(map[i][j] <= k)
                        visited[i][j] = true;
                }

            int cnt = 0;
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(visited[i][j])
                        continue;

                    cnt++;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int d = 0 ; d < 4 ; d++){
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
                                continue;
                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            res = Math.max(res, cnt);
        }

        System.out.println(res);
        br.close();
    }

}
