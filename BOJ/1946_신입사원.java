import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1946_신입사원 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < T ; t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken());
            }

            int ans = 1;
            int max = arr[0];
            for(int i = 1 ; i < N ; i++){
                if(arr[i] < max){
                    ans++;
                    max = arr[i];
                }
            }

            System.out.println(ans);
        }
        br.close();
    }
}
