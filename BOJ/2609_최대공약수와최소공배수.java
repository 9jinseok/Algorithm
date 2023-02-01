import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bw.write(gcd(N, M) + "\n" + lcm(N, M) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int gcd(int n, int m){
        while(m != 0){
            int r = n % m;
            n = m;
            m = r;
        }

        return n;
    }

    public static int lcm(int n, int m){
        return (n * m) / gcd(n, m);
    }
}
