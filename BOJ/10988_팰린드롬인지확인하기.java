import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10988_팰린드롬인지확인하기
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        for(int i = 0 ; i < input.length / 2 ; i++)
            if(input[i] != input[input.length - 1 - i]) {
                System.out.println(0);
                return;
            }

        System.out.println(1);
        br.close();
    }
}