import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산 {
    public static int r, c, t;
    public static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[100][100];
        for(int i = 0 ; i < 3 ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int R = 3, C = 3;
        int[] cnt = new int[101];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
            if(a[1] == b[1])
                return a[0] - b[0];
            else
                return a[1] - b[1];
        }
        );

        int time = 0;
        for(; true ; time++){
            if(map[r - 1][c - 1] == t)
                break;
            if(time > 100){
                time = -1;
                break;
            }
            if(R >= C){
                int nextC = 0;
                for(int i = 0 ; i < R ; i++){
                    Arrays.fill(cnt, 0);
                    for(int j = 0 ; j < C ; j++)
                        cnt[map[i][j]]++;
                    for(int j = 1 ; j <= 100 ; j++)
                        if(cnt[j] > 0)
                            pq.add(new int[]{j, cnt[j]});
                    if(nextC < pq.size() * 2)
                        nextC = pq.size() * 2;
                    int idx = 0;
                    while(!pq.isEmpty()){
                        int[] cur = pq.poll();
                        map[i][idx++] = cur[0];
                        map[i][idx++] = cur[1];
                    }
                    while(idx < 100)
                        map[i][idx++] = 0;
                }
                C = nextC;
            }
            else{
                int nextR = 0;
                for(int i = 0 ; i < C ; i++){
                    Arrays.fill(cnt, 0);
                    for(int j = 0 ; j < R ; j++)
                        cnt[map[j][i]]++;
                    for(int j = 1 ; j <= 100 ; j++)
                        if(cnt[j] > 0)
                            pq.add(new int[]{j, cnt[j]});
                    if(nextR < pq.size() * 2)
                        nextR = pq.size() * 2;
                    int idx = 0;
                    while(!pq.isEmpty()){
                        int[] cur = pq.poll();
                        map[idx++][i] = cur[0];
                        map[idx++][i] = cur[1];
                    }
                    while(idx < 100)
                        map[idx++][i] = 0;
                }
                R = nextR;
            }
        }

        bw.write(time + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

}