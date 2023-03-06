import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11866_요네푸스문제0 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= N ; i++)
            list.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int l = N;
        int idx = 0;
        for(int i = 0 ; i < N ; i++){
            idx = (idx + K - 1  ) % l;
            sb.append(list.remove(idx)).append(", ");
            l--;
        }

        sb.delete(sb.lastIndexOf(","),sb.length()).append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
