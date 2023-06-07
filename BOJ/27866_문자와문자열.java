import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_27866_문자와문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        System.out.println(input[Integer.parseInt(br.readLine()) - 1]);

        br.close();
    }
}
