import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_25314_코딩은체육과목입니다 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i += 4){
            System.out.print("long ");
        }

        System.out.println("int");
        br.close();
    }
}
