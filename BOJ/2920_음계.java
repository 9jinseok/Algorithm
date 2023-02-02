import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2920_음계 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean a = true, d = true;

        int n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i < 8 ; i++){
            int m = Integer.parseInt(st.nextToken());
            if(m + 1 != n)
                d = false;
            if(m - 1 != n)
                a = false;
            n = m;
        }

        if(a)
            bw.write("ascending\n");
        else if(d)
            bw.write("descending\n");
        else
            bw.write("mixed\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
