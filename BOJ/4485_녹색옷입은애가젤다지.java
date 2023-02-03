import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main_4485_녹색옷입은애가젤다지 {
    static int[][] dist, map;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int t = 1 ;; t++){
            int N = Integer.parseInt(br.readLine());
            if(N == 0)
                break;
            map = new int[N][N];
            dist = new int[N][N];

            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N ; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            boolean[][] visited = new boolean[N][N];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
            pq.add(new int[]{0, 0, 0});
            dist[0][0] = map[0][0];

            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                if(cur[0] == N - 1 && cur[1] == N - 1){
                    bw.write("Problem " + t + ": " + cur[2] + "\n");
                    break;
                }

                if(visited[cur[0]][cur[1]])
                    continue;
                visited[cur[0]][cur[1]] = true;

                for(int d = 0 ; d < 4 ; d++){
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
                        continue;

                    if(dist[cur[0]][cur[1]] + map[nx][ny] < dist[nx][ny]){
                        dist[nx][ny] = dist[cur[0]][cur[1]] + map[nx][ny];
                        pq.add(new int[]{nx, ny, dist[nx][ny]});
                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
