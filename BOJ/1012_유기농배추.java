import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_1012_유기농배추 {

    static int T, N, M, K;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < T ; t++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            visited = new boolean[N][M];
            for(int i = 0 ; i < K ; i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                visited[Y][X] = true;
            }
            int res = 0;
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    if(visited[i][j]){
                        res++;
                        Queue<int[]> q = new ArrayDeque<>();
                        q.add(new int[]{i, j});
                        visited[i][j] = false;

                        while(!q.isEmpty()){
                            int[] cur = q.poll();

                            for(int d = 0 ; d < 4 ; d++){
                                int nx = cur[0] + dx[d];
                                int ny = cur[1] + dy[d];

                                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                                    continue;

                                if(visited[nx][ny]){
                                    q.add(new int[]{nx, ny});
                                    visited[nx][ny] = false;
                                }
                            }
                        }
                    }
                }
            }

            bw.write(res + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
