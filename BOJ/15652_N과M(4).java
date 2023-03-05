import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652_N과M4 {
    static int N, M;
    static int[] order;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        order = new int[M];
        sb = new StringBuilder();
        perm(1, 0);

        System.out.print(sb.toString());
        br.close();
    }

    public static void perm(int start, int r){
        if(r == M){
            for(int i = 0 ; i < M ; i++)
                sb.append(order[i]).append(" ");
            sb.append("\n");
        }
        else{
            for(int i = start ; i <= N ; i++){
                order[r] = i;
                perm(i, r + 1);
            }
        }
    }
}