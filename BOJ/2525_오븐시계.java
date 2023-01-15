import java.io.*;
import java.util.*;

public class Main_2525_오븐시계 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int C = Integer.parseInt(br.readLine());
        
        int time = A * 60 + B + C;
        
        int H = (time / 60) % 24;
        int M = time % 60;
        
        bw.write(H + " " + M + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

}
