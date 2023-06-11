import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2566_최댓값 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = 0;
        int x = 1;
        int y = 1;

        for(int i = 1 ; i <= 9 ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= 9 ; j++){
                int n = Integer.parseInt(st.nextToken());
                if(n > max){
                    max = n;
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(x + " " + y);

        br.close();
    }
}
