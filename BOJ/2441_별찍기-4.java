import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2441_별찍기4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int k = 0;
        while(N > 0){
            for(int i = 0 ; i < k ; i++)
                bw.write(" ");
            for(int i = 0 ; i < N ; i++)
                bw.write("*");
            bw.write("\n");
            N--;
            k++;
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
