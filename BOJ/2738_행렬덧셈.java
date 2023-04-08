import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2738_행렬덧셈
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++)
                map[i][j] += Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < N ; i++) {
            for (int j = 0; j < M; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        br.close();
    }
}