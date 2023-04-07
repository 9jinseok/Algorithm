import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_23288_주사위굴리기2 {
    static int N, M, K, score, dir = 0, x = 0, y = 0, max;
    static int map[][];
    static int dice[] = new int[]{1, 2, 3, 4, 5, 6};
                                //전 상  우 좌 하  후
    static int[] dx = new int[]{0, 1, 0, -1}, dy = new int[]{1, 0, -1, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        score = 0;
        for(int i = 0 ; i < K ; i++){
            move();
        }

        System.out.println(score);
        br.close();
    }

    public static void move(){
        roll();
        if(dice[5] > map[x][y])
            dir = (dir + 1) % 4;
        else if(dice[5] < map[x][y])
            dir = (dir + 3) % 4;

        visited = new boolean[N][M];
        max = 0;
        dfs(x, y);
        score += max * map[x][y];
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        max++;
        for(int d = 0 ; d < 4 ; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(isIn(nx, ny) && !visited[nx][ny] && map[x][y] == map[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    public static boolean isIn(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void roll(){
        if(!isIn(x + dx[dir], y + dy[dir]))
            dir = (dir + 2) % 4;
        x += dx[dir];
        y += dy[dir];
        switch(dir){
            case 0:
                dice = new int[]{dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]};
                break;
            case 1:
                dice = new int[]{dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]};
                break;
            case 2:
                dice = new int[]{dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]};
                break;
            case 3:
                dice = new int[]{dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]};
                break;
        }
    }
}
