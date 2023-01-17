import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {
    public static int N, L, R, res = 0;
    public static boolean chk;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        while(true) {
            visited = new boolean[N][N];
            chk = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            if(!chk) {
                bw.write(res + "\n");
                break;
            }
            res++;
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        ArrayList<int[]> list = new ArrayList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            list.add(cur);
            for(int d = 0 ; d < 4 ; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]){
                    int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
                    if(diff >= L && diff <= R) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        int n = 0;
        int sum = 0;
        for(int[] pos : list){
            n++;
            sum += map[pos[0]][pos[1]];
        }
        if(n >= 2)
            chk = true;
        for(int[] pos : list){
            map[pos[0]][pos[1]] = sum / n;
        }
    }

}
