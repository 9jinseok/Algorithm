import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2455_지능형기차 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = 0;
        int max = 0;
        for(int i = 0 ; i < 4 ; i++){
            st = new StringTokenizer(br.readLine());
            n -= Integer.parseInt(st.nextToken());
            n += Integer.parseInt(st.nextToken());
            max = Math.max(max, n);
        }

        System.out.println(max);
        br.close();
    }
}
