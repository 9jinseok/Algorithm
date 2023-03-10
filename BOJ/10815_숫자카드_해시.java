import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_10815_숫자카드_해시 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            map.put(Integer.parseInt(st.nextToken()), 1);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            bw.write(map.getOrDefault(Integer.parseInt(st.nextToken()), 0) + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}