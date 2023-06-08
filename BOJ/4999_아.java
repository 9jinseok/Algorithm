import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_4999_아 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String wanted = br.readLine();

        if(input.length() >= wanted.length())
            System.out.println("go");
        else
            System.out.println("no");

        br.close();
    }
}
