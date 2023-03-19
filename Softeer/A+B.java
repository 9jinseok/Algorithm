import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_AB
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println("Case #" + (i + 1) + ": " + (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())));
        }

        br.close();
    }
}