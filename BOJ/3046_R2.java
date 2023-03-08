import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3046_R2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmp = Integer.parseInt(st.nextToken());
        bw.write((Integer.parseInt(st.nextToken()) * 2 - tmp) + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}