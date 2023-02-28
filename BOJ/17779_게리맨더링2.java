import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_17779_게리맨더링2 {
    static int N, sum = 0, res = Integer.MAX_VALUE;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }

        for(int x = 1 ; x <= N ; x++){
            for(int y = 1 ; y <= N ; y++){
                for(int d1 = 1 ; d1 <= y - 1 ; d1++){
                    for(int d2 = 1 ; d2 <= N - y ; d2++){
                        if(x + d1 + d2 <= N)
                            calc(x, y, d1, d2);
                    }
                }
            }
        }

        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void calc(int x, int y, int d1, int d2) {
        int[] sums = new int[5];
        int r, c;

        for( r = 1 ; r < x + d1 ; r++)
            for( c = 1 ; c <= y ; c++){
                if(r < x || (c <= y - (r - x + 1)))
                    sums[0] += map[r - 1][c - 1];
            }

        for( r = 1 ; r <= x + d2 ; r++)
            for( c = y + 1 ; c <= N ; c++) {
                if(r <= x || c - y - 1 >= r - x)
                    sums[1] += map[r - 1][c - 1];
            }

        for( r = x + d1 ; r <= N ; r++)
            for( c = 1 ; c < y - d1 + d2 ; c++) {
                if(c < y - d1 - (x + d1 - r))
                    sums[2] += map[r - 1][c - 1];
            }

        for( r = x + d2 + 1 ; r <= N ; r++)
            for( c = y - d1 + d2 ; c <= N ; c++) {
                if(c >= y + d2 + x + d2 + 1 - r)
                    sums[3] += map[r - 1][c - 1];
            }

        sums[4] = sum - sums[0] - sums[1] - sums[2] - sums[3];

        int max = 0, min = Integer.MAX_VALUE;
        for(int i = 0 ; i < 5 ; i++){
            max = Math.max(max, sums[i]);
            min = Math.min(min, sums[i]);
        }

        res = Math.min(res, max - min);
    }
}
