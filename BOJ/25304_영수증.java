import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_25304_영수증 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int price = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            price -= Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }

        if(price == 0)
            bw.write("Yes\n");
        else
            bw.write("No\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
