import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_6087_레이저통신 {
    static int W, H;
    static int[][] map;
    static int x1 = -1, y1, x2, y2;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        for(int i = 0 ; i < H ; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0 ; j < W ; j++) {
                map[i][j] = input[j];
                if(map[i][j] == 'C') {
                    if(x1 == -1) {
                        x1 = i;
                        y1 = j;
                    }
                    else {
                        x2 = i;
                        y2 = j;
                    }
                }
            }
        }

        visited = new boolean[H][W][4];
        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2) -> o1[3] - o2[3]);
        pq.add(new int[]{x1, y1, -1, 0});

        int res = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[2] >= 0)
                visited[cur[0]][cur[1]][cur[2]] = true;
            if(cur[0] == x2 && cur[1] == y2) {
                bw.write(cur[3] + "\n");
                break;
            }
            for(int d = 0 ; d < 4 ; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                int cnt = cur[3];
                if(cur[2] != -1 && d != cur[2])
                    cnt++;
                if(isIn(nx, ny) && map[nx][ny] != '*' && !visited[nx][ny][d]) {
                    pq.add(new int[] {nx, ny, d, cnt});
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}
