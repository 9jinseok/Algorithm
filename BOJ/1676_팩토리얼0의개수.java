import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1676_팩토리얼0의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 1 ; i <= N ; i++){
            int tmp = i;
            while(tmp % 5 == 0){
                tmp /= 5;
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}