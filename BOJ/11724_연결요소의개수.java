import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main_11724_연결요소의개수 {
    static int N, M;
    static List<Integer>[] edgeList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList[N + 1];

        for(int i = 1 ; i <= N ; i++)
            edgeList[i] = new ArrayList<>();

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edgeList[from].add(to);
            edgeList[to].add(from);
        }

        int res = 0;

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 1 ; i <= N ; i++){
            if(visited[i])
                continue;
            res++;

            q.add(i);
            visited[i] = true;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int to : edgeList[cur]){
                    if(!visited[to]) {
                        q.add(to);
                        visited[to] = true;
                    }
                }

            }
        }
        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
