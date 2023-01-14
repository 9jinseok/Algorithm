import java.io.*;
import java.util.*;

public class Main_2268_수들의합7 {

    private static long[] tree;
    private static int OFFSET;

    private static void init(int n) {
        for(OFFSET = 1 ; OFFSET < n ; OFFSET *= 2);
        tree = new long[OFFSET * 2 + 1];
    }

    private static long query(int from, int to) {
        long sum = 0L;
        from += OFFSET;
        to += OFFSET;
        while(from <= to) {
            if(from % 2 == 1)
                sum += tree[from++];
            if(to % 2 == 0)
                sum += tree[to--];
            from /= 2;
            to /= 2;
        }
        return sum;
    }

    private static void update(int idx, int val){
        idx += OFFSET;
        tree[idx] = val;
        idx /= 2;
        while(idx > 0){
            tree[idx] = tree[idx*2] + tree[idx*2 + 1];
            idx /= 2;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        init(N);

        int a, b, c;
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == 1)
                update(b - 1, c);
            else{
                if(b > c)
                    bw.write(query(c - 1, b - 1) + "\n");
                else
                    bw.write(query(b - 1, c - 1) + "\n");

            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
