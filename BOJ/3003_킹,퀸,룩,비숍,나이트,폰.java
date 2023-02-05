import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_3003_킹퀸룩비숍나이트폰 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[]{1,1,2,2,2,8};

        for(int i = 0 ; i < 6 ; i++){
            bw.write(arr[i] - Integer.parseInt(st.nextToken()) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
