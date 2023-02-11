import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_2309_일곱난쟁이 {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        arr = new int[9];
        int sum = 0;
        for(int i = 0 ; i < 9 ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        for(int i = 0 ; i < 8 ; i++){
            int tmp = sum - arr[i];
            for(int j = i + 1 ; j < 9 ; j++){
                if(tmp - arr[j] == 100){
                    for(int k = 0 ; k < 9 ; k++)
                        if(k != i && k != j)
                            System.out.println(arr[k]);
                    return;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
