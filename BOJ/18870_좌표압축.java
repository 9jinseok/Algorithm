import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_18870_좌표압축 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] arr2 = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            arr2[i] = n;
        }

        Arrays.sort(arr2);
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        map.put(arr2[0], idx++);
        for(int i = 1 ; i < N ; i++ ){
            if(arr2[i] == arr2[i - 1])
                continue;
            map.put(arr2[i], idx++);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < N ; i++)
            sb.append(map.get(arr[i])).append(" ");
        System.out.println(sb);
        br.close();
    }
}
