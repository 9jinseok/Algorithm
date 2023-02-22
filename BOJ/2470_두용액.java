import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470_두용액 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int p = 0;
        int ansP = 0;
        int q = N - 1;
        int ansQ = N - 1;
        int sum = arr[p] + arr[q];

        while(p < q){
            int tmp = arr[p] + arr[q];
            if(Math.abs(sum) > Math.abs(tmp)){
                sum = tmp;
                ansP = p;
                ansQ = q;
                if(sum == 0)
                    break;
            }

            if(tmp < 0)
                p++;
            else
                q--;
        }

        bw.write(arr[ansP] + " " + arr[ansQ] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
