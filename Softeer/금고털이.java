import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_금고털이
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);
        int idx = 0;
        int res = 0;
        while(W > 0){
            if(W > arr[idx][0]){
                res += arr[idx][0] * arr[idx][1];
                W -= arr[idx][0];
                idx++;
            }
            else{
                res += W * arr[idx][1];
                break;
            }
        }
        System.out.println(res);
        br.close();
    }
}