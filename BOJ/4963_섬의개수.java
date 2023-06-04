import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {

    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1}, dy = {0, -1, 0, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while(N != 0){
            boolean[][] visited = new boolean[M][N];
            for(int i = 0 ; i < M ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N ; j++){
                    if(st.nextToken().equals("0"))
                        visited[i][j] = true;
                }
            }

            int cnt = 0;
            for(int i = 0 ; i < M ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(visited[i][j])
                        continue;
                    cnt++;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int d = 0 ; d < 8 ; d++){
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];
                            if(nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny])
                                continue;
                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

            System.out.println(cnt);
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        }

        br.close();
    }
}
