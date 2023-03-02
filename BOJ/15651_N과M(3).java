import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15651_N과M3 {
    static int N, M;
    static int[] order;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        order = new int[M];
        perm(0);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void perm(int r){
        if(r == M){
            for(int i = 0 ; i < M ; i++)
                sb.append(order[i] + " ");
            sb.append("\n");
        }
        else{
            for(int i = 1 ; i <= N ; i++){
                order[r] = i;
                perm(r + 1);
            }
        }
    }

}