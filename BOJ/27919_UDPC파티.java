import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_27919_UDPC파티 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        int u = 0;
        int d = 0;
        for(int i = 0 ; i < input.length ; i++) {
            if (input[i] == 'U' || input[i] == 'C')
                u++;
            else
                d++;
        }

        if(d == 0)
            System.out.println("U");
        else if(u > (d+1)/2)
            System.out.println("UDP");
        else
            System.out.println("DP");

        br.close();
    }
}
