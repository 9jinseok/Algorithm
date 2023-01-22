import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14428_수열과쿼리16 {

    private static Node[] tree;
    private static int[] arr;
    private static int OFFSET;

    private static void init(int n) {
        for(OFFSET = 1 ; OFFSET < n ; OFFSET *= 2);
        tree = new Node[OFFSET * 2 + 1];
        for(int i = 0; i < n ; i++)
            tree[OFFSET + i] = new Node(i + 1, arr[i]);
        for(int i = n ; i < OFFSET ; i++)
            tree[OFFSET + i] = new Node(-1, Integer.MAX_VALUE);
        for(int i = OFFSET - 1 ; i > 0 ; i--){
            if(tree[i * 2].val <= tree[i * 2 + 1].val)
                tree[i] = new Node(tree[i * 2].idx, tree[i * 2].val);
            else
                tree[i] = new Node(tree[i * 2 + 1].idx, tree[i * 2 + 1].val);
        }
    }
    private static int query(int from, int to) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        from += OFFSET;
        to += OFFSET;
        while(from <= to) {
            if(from % 2 == 1) {
                if(min > tree[from].val || (min == tree[from].val && idx > tree[from].idx)) {
                    min = tree[from].val;
                    idx = tree[from].idx;
                }
                from++;
            }
            if(to % 2 == 0) {
                if(min > tree[to].val || (min == tree[to].val && idx > tree[to].idx)) {
                    min = tree[to].val;
                    idx = tree[to].idx;
                }
                to--;
            }
            from /= 2;
            to /= 2;
        }
        return idx;
    }

    private static void update(int idx, int val) {
        idx += OFFSET;
        tree[idx] = new Node(tree[idx].idx, val);
        idx /= 2;
        while(idx > 0) {
            if(tree[idx * 2].val <= tree[idx * 2 + 1].val)
                tree[idx] = new Node(tree[idx * 2].idx, tree[idx * 2].val);
            else
                tree[idx] = new Node(tree[idx * 2 + 1].idx, tree[idx * 2 + 1].val);
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

    public static class Node{
        int idx;
        int val;

        public Node(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
}
