import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1032_명령프롬프트 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] arr = new char[N][];
        for(int i = 0 ; i < N ; i++){
            arr[i] = br.readLine().toCharArray();
        }

        int L = arr[0].length;
        char[] ans = new char[L];

        for(int i = 0 ; i < L ; i++){
            char c = arr[0][i];
            for(int j = 1 ; j < N ; j++)
                if(c != arr[j][i]){
                    c = '?';
                    break;
                }
            ans[i] = c;
        }

        System.out.println(ans);
        br.close();
    }
}
