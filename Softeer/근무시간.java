import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_근무시간
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st, st2;

        int res = 0;
        for(int i = 0 ; i < 5 ; i++){
            st = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(st.nextToken(),":");
            res -= Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken());
            st2 = new StringTokenizer(st.nextToken(),":");
            res += Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken());
        }

        System.out.println(res);
        br.close();
    }
}