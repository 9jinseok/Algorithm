import java.io.*;
import java.util.*;
public class Main {

    private static long[] tree;
    private static long[] arr;
    private static int OFFSET;
    private static int MOD = 1000000007;

    private static void init(int n) {
        for(OFFSET = 1 ; OFFSET < n ; OFFSET *= 2);
        tree = new long[OFFSET * 2 + 1];
        for(int i = 0; i < n ; i++)
            tree[OFFSET + i] = arr[i];
        for(int i = n ; i < OFFSET ; i++)
            tree[OFFSET + i] = 0L;
        for(int i = OFFSET - 1 ; i > 0 ; i--)
            tree[i] = (tree[i*2] * tree[i*2 + 1]) % MOD;
    }

    private static long query(int from, int to) {
        long mul = 1L;
        from += OFFSET;
        to += OFFSET;
        while(from <= to) {
            if(from % 2 == 1)
                mul = (mul * tree[from++]) % MOD;
            if(to % 2 == 0)
                mul = (mul * tree[to--]) % MOD;
            from /= 2;
            to /= 2;
        }
        return mul;
    }

    private static void update(int idx, int val){
        idx += OFFSET;
        tree[idx] = val;
        idx /= 2;
        while(idx > 0){
            tree[idx] = (tree[idx*2] * tree[idx*2 + 1]) % MOD;
            idx /= 2;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        for(int i = 0 ; i < N ; i++)
            arr[i] = Long.parseLong(br.readLine());
        init(N);

        int a, b, c;
        for(int i = 0 ; i < M + K ; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken());
            if(a == 1)
                update(b, c);
            else
                bw.write(query(b, c - 1)+ "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
