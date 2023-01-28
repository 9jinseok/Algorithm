import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16235_나무재테크 {
    static int N, M, K;
    static int[][] A, map;
    static int[] dx = {-1,-1,-1,0,0,1,1,1}, dy = {-1,0,1,-1,1,-1,0,1};
    static PriorityQueue<int[]> trees = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        A = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            Arrays.fill(map[i], 5);
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            trees.add(new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())});
        }

        for(int k = 0 ; k < K ; k++) {
            ss();
            fall();
            winter();
        }

        bw.write(trees.size() + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void ss(){
        PriorityQueue<int[]> newTrees = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        int[][] dead = new int[N][N];
        while(!trees.isEmpty()){
            int[] tree = trees.poll();
            if(tree[2] > map[tree[0]][tree[1]]){
                dead[tree[0]][tree[1]] += tree[2]/2;
            }
            else{
                map[tree[0]][tree[1]] -= tree[2];
                newTrees.add(new int[]{tree[0], tree[1], tree[2] + 1});
            }
        }
        trees = newTrees;
        for(int i = 0 ; i < N ; i++)
            for(int j = 0 ; j < N ; j++)
                map[i][j] += dead[i][j];
    }

    public static void fall(){
        ArrayList<int[]> newTrees = new ArrayList<>();
        for(int[] tree : trees){
            if(tree[2] % 5 == 0){
                for(int d = 0 ; d < 8 ; d++){
                    if(isIn(tree[0] + dx[d], tree[1] + dy[d]))
                        newTrees.add(new int[]{tree[0] + dx[d], tree[1] + dy[d], 1});
                }
            }
        }
        trees.addAll(newTrees);
    }

    public static void winter(){
        for(int i = 0 ; i < N ; i++)
            for(int j = 0 ; j < N ; j++)
                map[i][j] += A[i][j];
    }

    public static boolean isIn(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
