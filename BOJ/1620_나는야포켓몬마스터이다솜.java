import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N + 1];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 1 ; i <= N ; i++) {
            arr[i] = br.readLine();
            map.put(arr[i], i);
        }

        for(int i = 0 ; i < M ; i++){
            String cmd = br.readLine();
            if('1' <= cmd.charAt(0) && '9' >= cmd.charAt(0)){
                int n = Integer.parseInt(cmd);
                System.out.println(arr[n]);
            }
            else{
                System.out.println(map.get(cmd));
            }
        }

        br.close();
    }
}
