import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2440_별찍기3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while(N > 0){
            for(int i = 0 ; i < N ; i++)
                bw.write("*");
            bw.write("\n");
            N--;
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
