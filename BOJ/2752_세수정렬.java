import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2752_세수정렬
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if(A > B){
            if(B > C)
                System.out.println(C + " " + B + " " + A);
            else if(A > C)
                System.out.println(B + " " + C + " " + A);
            else
                System.out.println(B + " " + A + " " + C);
        }
        else{
            if(A > C)
                System.out.println(C + " " + A + " " + B);
            else if(B > C)
                System.out.println(A + " " + C + " " + B);
            else
                System.out.println(A + " " + B + " " + C);
        }

        br.close();
    }
}