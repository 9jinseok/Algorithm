import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_17822_원판돌리기 {
    static int N, M, T;
    static Circle[] circles;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        circles = new Circle[N + 1];
        for (int i = 0; i < N; i++) {
            int[] tmp = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                tmp[j] = Integer.parseInt(st.nextToken());
            circles[i + 1] = new Circle(tmp);
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (d == 1)
                k = M - k;
            for (int j = x; j <= N; j += x)
                circles[j].rotate(k);
            check();
        }

        int sum = 0;
        for (int i = 1; i <= N; i++){
            for (int j = 0; j < M; j++) {
                sum += circles[i].nums[j];
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void check(){
        boolean[][] visited = new boolean[N + 1][M];
        boolean chk = false;
        double sum = 0;
        int cnt = 0;
        for(int i = 1 ; i <= N ; i++){
            for(int j = 0 ; j < M ; j++){
                int num = circles[i].nums[j];
                if(num == 0)
                    continue;
                if((i > 1 && num == circles[i - 1].nums[j]) || (i < N && num == circles[i + 1].nums[j])
                        || (num == circles[i].nums[(j - 1 + M)%M]) || (num == circles[i].nums[(j + 1)%M])){
                    visited[i][j] = true;
                    chk = true;
                }
                else{
                    sum += num;
                    cnt++;
                }
            }
        }

        if(chk){
            for(int i = 1 ; i <= N ; i++)
                for(int j = 0 ; j < M ; j++)
                    if(visited[i][j]) {
                        circles[i].nums[j] = 0;
                    }
        }
        else{
            sum = sum / cnt;
            for(int i = 1 ; i <= N ; i++)
                for(int j = 0 ; j < M ; j++) {
                    if(circles[i].nums[j] == 0)
                        continue;
                    if(circles[i].nums[j] > sum)
                        circles[i].nums[j]--;
                    else if(circles[i].nums[j] < sum)
                        circles[i].nums[j]++;
                }
        }
    }


    public static class Circle{
        int[] nums;

        public Circle(int[] nums){
            this.nums = nums;
        }

        public void rotate(int k){
            int[] tmp = new int[M];
            System.arraycopy(nums, 0, tmp, 0, M);
            for(int i = k ; i < M ; i++)
                nums[i] = tmp[i - k];
            for(int i = 0 ; i < k ; i++)
                nums[i] = tmp[M - k + i];
        }
    }
}
