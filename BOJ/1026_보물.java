import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1026_보물 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] brr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st1.nextToken());
            brr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);
        Arrays.sort(brr);

        int res = 0;

        for(int i = 0 ; i < N ; i++){
            res += arr[i] * brr[N - 1 - i];
        }

        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
