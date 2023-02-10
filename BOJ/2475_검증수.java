import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_2475_검증수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = 0;
        for(int i = 0 ; i < 5 ; i++){
            int m = Integer.parseInt(st.nextToken());
            n += m * m;
        }

        bw.write(n%10 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
