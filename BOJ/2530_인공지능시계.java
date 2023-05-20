import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2530_인공지능시계 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sec = 0;
        sec += 60 * 60 * Integer.parseInt(st.nextToken());
        sec += 60 * Integer.parseInt(st.nextToken());
        sec += Integer.parseInt(st.nextToken());

        sec += Integer.parseInt(br.readLine());

        System.out.println(((sec / (60 * 60)) % 24) + " " + ((sec / 60) % 60) + " " + (sec % 60));
        br.close();
    }
}
