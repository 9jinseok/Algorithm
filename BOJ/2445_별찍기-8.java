import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2445_별찍기8 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= N ; i++){
            for(int j = 0 ; j < i ; j++)
                System.out.print("*");
            for(int j = 0 ; j < 2 * (N - i) ; j++)
                System.out.print(" ");
            for(int j = 0 ; j < i ; j++)
                System.out.print("*");
            System.out.println();
        }
        for(int i = N - 1 ; i >= 1 ; i--){
            for(int j = 0 ; j < i ; j++)
                System.out.print("*");
            for(int j = 0 ; j < 2 * (N - i) ; j++)
                System.out.print(" ");
            for(int j = 0 ; j < i ; j++)
                System.out.print("*");
            System.out.println();
        }

        br.close();
    }
}
