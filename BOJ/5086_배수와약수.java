import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5086_배수와약수
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A == 0)
                break;
            if(A % B == 0)
                System.out.println("multiple");
            else if(B % A == 0)
                System.out.println("factor");
            else
                System.out.println("neither");
        }
        br.close();
    }
}