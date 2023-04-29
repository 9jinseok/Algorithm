import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1009_분산처리 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < T ; t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tmp = 1;
            for(int i = 0 ; i < b ; i++)
                tmp = (tmp * a) % 10;
            if(tmp == 0)
                tmp = 10;
            System.out.println(tmp);
        }
        br.close();
    }
}
