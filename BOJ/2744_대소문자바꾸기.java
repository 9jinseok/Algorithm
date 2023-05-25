import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2744_대소문자바꾸기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        for(char c : input) {
            if (Character.isLowerCase(c))
                System.out.print(Character.toUpperCase(c));
            else
                System.out.print(Character.toLowerCase(c));
        }

        br.close();
    }
}
