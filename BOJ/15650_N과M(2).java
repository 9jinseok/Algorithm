import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_15650_N과M2 {

    static int N, M;
    static int[] order;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        order = new int[M];
        visited = new boolean[N + 1];
        perm(0, 1);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void perm(int r, int start){
        if(r == M){
            for(int i = 0 ; i < r ; i++)
                System.out.print(order[i] + " ");
            System.out.println();
        }
        else{
            for(int i = start ; i <= N ; i++){
                if(!visited[i]){
                    visited[i] = true;
                    order[r] = i;
                    perm(r + 1, i + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
