import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기 {
    static int N, K;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new long[K];

        for(int i = 0 ; i < K ; i++)
            arr[i] = Long.parseLong(br.readLine());

        long start = 0;
        long end = Long.MAX_VALUE;
        while(start + 1 < end){
            long mid = (start + end) / 2;
            if(check(mid))
                start = mid;
            else
                end = mid;
        }

        System.out.println(start);
        br.close();
    }

    public static boolean check(long len){
        int cnt = 0;
        for(int i = 0 ; i < K ; i++)
            cnt += arr[i] / len;
        if(cnt >= N)
            return true;
        return false;
    }
}
