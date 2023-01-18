import java.io.*;
import java.util.*;

public class Main {
    public static int R, T, C, ax, bx;
    public static int[][] map;
    public static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        ax = -1;
        bx = -1;
        for(int i = 0 ; i < R ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < C ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    if(ax == -1)
                        ax = i;
                    else
                        bx = i;
                }
            }
        }

        for(int t = 0 ; t < T ; t++) {
            spread();
            clean();
        }

        int res = 0;
        for(int i = 0 ; i < R ; i++)
            for(int j = 0 ; j < C ; j++)
                if(map[i][j] > 0)
                    res += map[i][j];

        bw.write(res + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void spread(){
        int[][] newMap = new int[R][C];
        for(int i = 0 ; i < R ; i++)
            for(int j = 0 ; j < C ; j++){
                if(map[i][j] > 0){
                    int cnt = 0;
                    for(int d = 0 ; d < 4 ; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(isIn(nx, ny) && map[nx][ny] != -1){
                            cnt++;
                            newMap[nx][ny] += map[i][j] / 5;
                        }
                    }
                    newMap[i][j] += map[i][j] - (map[i][j] / 5) * cnt;
                }
            }

        for(int i = 0 ; i < R ; i++)
            System.arraycopy(newMap[i], 0, map[i], 0, C);
        map[ax][0] = -1;
        map[bx][0] = -1;
    }

    public static void clean(){
        int[][] newMap = new int[R][C];
        for(int i = 1 ; i < R - 1 ; i++)
            System.arraycopy(map[i], 1, newMap[i], 1, C - 2);
        for(int i = 0 ; i < C - 1 ; i++)
            newMap[0][i] = map[0][i + 1];
        for(int i = C - 1 ; i > 1 ; i--)
            newMap[ax][i] = map[ax][i - 1];
        for(int i = C - 1 ; i > 1 ; i--)
            newMap[bx][i] = map[bx][i - 1];
        for(int i = 0 ; i < C - 1 ; i++)
            newMap[R - 1][i] = map[R - 1][i + 1];

        for(int i = ax - 1 ; i > 0 ; i--)
            newMap[i][0] = map[i - 1][0];
        for(int i = 0 ; i < ax ; i++)
            newMap[i][C - 1] = map[i + 1][C - 1];
        for(int i = bx + 1 ; i < R - 1 ; i++)
            newMap[i][0] = map[i + 1][0];
        for(int i = R - 1 ; i > bx ; i--)
            newMap[i][C - 1] = map[i - 1][C - 1];

        for(int i = 0 ; i < R ; i++)
            System.arraycopy(newMap[i], 0, map[i], 0, C);
        map[ax][0] = -1;
        map[bx][0] = -1;
        map[ax][1] = 0;
        map[bx][1] = 0;
    }

    public static boolean isIn(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}