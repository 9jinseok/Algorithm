import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9086_문자열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < T ; t++){
            char[] str = br.readLine().toCharArray();
            System.out.println(str[0] + "" + str[str.length - 1]);
        }
        br.close();
    }
}
