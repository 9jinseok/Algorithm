import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {
    static int N, M, H;
    static boolean[][][] visited;
    static int[] dx = {1, 0 , -1, 0, 0, 0}, dy = {0, 1, 0, -1, 0, 0}, dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visited = new boolean[H][N][M];

        int cnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0 ; i < H ; i++){
            for(int j = 0 ; j < N ; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < M ; k++) {
                    int x = Integer.parseInt(st.nextToken());
                    if(x == 0)
                        cnt++;
                    else {
                        visited[i][j][k] = true;
                        if(x == 1)
                            q.add(new int[]{i, j, k, 0});
                    }
                }
            }
        }

        int day = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            day = cur[3];
            for(int d = 0 ; d < 6 ; d++){
                int nz = cur[0] + dx[d];
                int nx = cur[1] + dy[d];
                int ny = cur[2] + dz[d];
                if(isIn(nx, ny, nz) && !visited[nz][nx][ny]){
                    cnt--;
                    visited[nz][nx][ny] = true;
                    q.add(new int[]{nz, nx, ny, cur[3] + 1});
                }
            }
        }

        if(cnt > 0)
            System.out.println(-1);
        else
            System.out.println(day);
        br.close();
    }

    public static boolean isIn(int x, int y, int z){
        return x >= 0 && x < N && y >= 0 && y < M && z >= 0 && z < H;
    }
}
