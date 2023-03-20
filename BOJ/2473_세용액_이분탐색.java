import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_세용액_이분탐색
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

        long ansP = arr[0], ansQ = arr[N - 1], ansR = arr[1];
        long ans = ansP + ansQ + ansR;

        for(int p = 0 ; p < N - 2 ; p++)
            for(int q = p + 2 ; q < N ; q++) {
                int lo = p + 1, hi = q - 1;
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    long sum = arr[p] + arr[q] + arr[mid];
                    if (Math.abs(sum) < Math.abs(ans)) {
                        ans = sum;
                        ansP = arr[p];
                        ansQ = arr[q];
                        ansR = arr[mid];
                    }
                    if (sum == 0)
                        break;
                    if (sum > 0)
                        hi = mid - 1;
                    else
                        lo = mid + 1;
                }
            }

        System.out.println(ansP + " " + ansR + " " + ansQ);
        br.close();
    }
}