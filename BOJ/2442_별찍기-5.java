import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_2442_별찍기5 {

    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N - i - 1 ; j++)
                bw.write(" ");
            for(int j = 0 ; j < 2 * i + 1 ; j++)
                bw.write("*");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
