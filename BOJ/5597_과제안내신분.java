import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_5597_과제안내신분 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        boolean[] chk = new boolean[31];
        for(int i = 0 ; i < 28 ; i++)
            chk[Integer.parseInt(br.readLine())] = true;

        for(int i = 1 ; i < 31 ; i++)
            if(!chk[i])
                bw.write(i + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
