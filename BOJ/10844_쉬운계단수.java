import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_10844_쉬운계단수 {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[10];
        Arrays.fill(arr, 1);
        arr[0] = 0;
        for(int i = 1 ; i < N ; i++){
            int[] tmp = new int[10];
            tmp[0] = arr[1];
            for(int j = 1 ; j < 9 ; j++)
                tmp[j] = (arr[j-1] + arr[j+1]) % 1000000000;
            tmp[9] = arr[8];
            arr = tmp;
        }

        int sum = 0;
        for(int i = 0 ; i < 10 ; i++)
            sum = (sum + arr[i]) % 1000000000;
        bw.write(sum +  "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
