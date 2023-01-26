import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{N, 0});
        boolean[] visited = new boolean[100001];
        visited[N] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == M){
                bw.write(cur[1] + "\n");
                break;
            }
            if(cur[0] > 0 && !visited[cur[0] - 1]) {
                visited[cur[0] - 1] = true;
                q.add(new int[]{cur[0] - 1, cur[1] + 1});
            }
            if(cur[0] < 100000 && !visited[cur[0] + 1]) {
                visited[cur[0] + 1] = true;
                q.add(new int[]{cur[0] + 1, cur[1] + 1});
            }
            if(cur[0] <= 50000 && !visited[cur[0] * 2]) {
                visited[cur[0] * 2] = true;
                q.add(new int[]{cur[0] * 2, cur[1] + 1});
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
