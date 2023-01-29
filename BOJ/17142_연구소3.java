import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소3 {
    static int N, M, res, cnt = 0;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1}, order;
    static ArrayList<int[]> pos = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        order = new int[M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2)
                    pos.add(new int[]{i, j});
                else if(map[i][j] == 0)
                    cnt++;
            }
        }

        if(cnt == 0)
            bw.write("0\n");
        else {
            res = 10000;
            comb(0, 0);
            bw.write((res == 10000 ? -1 : res) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static void comb(int start, int r){
        if(r == M){
            spread(cnt);
        }
        else{
            for(int i = start ; i < pos.size() ; i++){
                order[r] = i;
                comb(i + 1, r + 1);
            }
        }
    }

    public static void spread(int empty){
        Queue<int[]> q = new ArrayDeque<>();
        boolean visited[][] = new boolean[N][N];
        for(int i = 0 ; i < M ; i++) {
            q.add(new int[]{pos.get(order[i])[0],pos.get(order[i])[1],0});
            visited[pos.get(order[i])[0]][pos.get(order[i])[1]] = true;
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] != 1) {
                    if (map[nx][ny] == 0)
                        empty--;
                    if (empty == 0) {
                        res = Math.min(res, cur[2] + 1);
                        return;
                    }
                    q.add(new int[]{nx, ny, cur[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
    public static boolean isIn(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
