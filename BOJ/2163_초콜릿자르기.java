import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2163_초콜릿자르기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()) - 1;
        int M = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(N + M * (N + 1));

        br.close();
    }
}
