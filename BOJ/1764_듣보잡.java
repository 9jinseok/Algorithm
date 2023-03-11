import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < N ; i++)
            set.add(br.readLine());

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        String[] ans = new String[M];
        for(int i = 0 ; i < M ; i++) {
            String str = br.readLine();
            if (set.contains(str))
                ans[idx++] = str;
        }

        Arrays.sort(ans,0, idx);
        sb.append(idx).append("\n");
        for(int i = 0 ; i < idx ; i++)
            sb.append(ans[i]).append("\n");
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}