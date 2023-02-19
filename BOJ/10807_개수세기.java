import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_10807_개수세기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] chk = new int[201];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
            chk[Integer.parseInt(st.nextToken()) + 100]++;

        bw.write(chk[Integer.parseInt(br.readLine()) + 100] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
