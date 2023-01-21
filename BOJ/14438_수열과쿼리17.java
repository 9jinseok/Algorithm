import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14438_수열과쿼리17 {

    private static int[] tree;
    private static int[] arr;
    private static int OFFSET;

    private static void init(int n) {
        for(OFFSET = 1 ; OFFSET < n ; OFFSET *= 2);
        tree = new int[OFFSET * 2 + 1];
        for(int i = 0; i < n ; i++)
            tree[OFFSET + i] = arr[i];
        for(int i = n ; i < OFFSET ; i++)
            tree[OFFSET + i] = 0;
        for(int i = OFFSET - 1 ; i > 0 ; i--)
            tree[i] = Math.min(tree[i*2], tree[i*2 + 1]);
    }

    private static int query(int from, int to) {
        int min = Integer.MAX_VALUE;
        from += OFFSET;
        to += OFFSET;
        while(from <= to) {
            if(from % 2 == 1) {
                min = Math.min(min, tree[from++]);
            }
            if(to % 2 == 0) {
                min = Math.min(min, tree[to--]);
            }
            from /= 2;
            to /= 2;
        }
        return min;
    }

    private static void update(int idx, int val) {
        idx += OFFSET;
        tree[idx] = val;
        idx /= 2;
        while(idx > 0) {
            tree[idx] = Math.min(tree[idx*2],tree[idx*2 + 1]);
            idx /= 2;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        init(N);

        int M = Integer.parseInt(br.readLine());
        int a, b, c;
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == 1)
                update(b - 1, c);
            else
                bw.write(query(b - 1, c - 1) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
