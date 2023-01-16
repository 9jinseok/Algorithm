import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2480_주사위세개 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if(a == b){
            if(b == c){
                bw.write("1" + a + "000\n");
            }
            else{
                bw.write("1" + a + "00\n");
            }
        }
        else if(b == c){
                bw.write("1" + b + "00\n");
        }
        else if(a == c){
                bw.write("1" + a + "00\n");
        }
        else{
            bw.write(Math.max(Math.max(a, b), c) + "00\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
