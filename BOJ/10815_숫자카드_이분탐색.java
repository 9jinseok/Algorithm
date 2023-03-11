import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815_숫자카드_이분탐색 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            int num = Integer.parseInt(st.nextToken());

            int low = 0;
            int high = N - 1;
            boolean chk = false;
            while(low <= high){
                int mid = (low + high) / 2;
                if(arr[mid] == num){
                    chk = true;
                    break;
                }
                if(arr[mid] > num){
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            if(chk)
                bw.write("1 ");
            else
                bw.write("0 ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}