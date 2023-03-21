import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_세용액_투포인터
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
            arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        long ansP = arr[0], ansQ = arr[1], ansR = arr[N - 1];
        long ans = ansP + ansQ + ansR;

        for(int p = 0 ; p < N - 2 ; p++){
            int q = p + 1, r = N - 1;
            while(q < r){
                long sum = arr[p] + arr[q] + arr[r];
                if(sum == 0){
                    ansP = arr[p];
                    ansQ = arr[q];
                    ansR = arr[r];
                    break;
                }
                if(Math.abs(sum) < Math.abs(ans)){
                    ans = sum;
                    ansP = arr[p];
                    ansQ = arr[q];
                    ansR = arr[r];
                }
                if(sum > 0)
                    r--;
                else
                    q++;
            }
        }

        System.out.println(ansP + " " + ansQ + " " + ansR);
        br.close();
    }
}