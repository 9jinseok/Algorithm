import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
    static int N, M;
    static ArrayList<int[]> edgeList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edgeList = new ArrayList<>();
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            edgeList.add(new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1});
        }

        boolean[] visited = new boolean[N];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        int res = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int[] edge : edgeList){
                if(edge[0] == cur && !visited[edge[1]]){
                    q.add(edge[1]);
                    visited[edge[1]] = true;
                    res++;
                }
                else if(edge[1] == cur && !visited[edge[0]]){
                    q.add(edge[0]);
                    visited[edge[0]] = true;
                    res++;
                }
            }
        }

        bw.write(res + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

}
