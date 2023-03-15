import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_8단변속기
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean asc = true, desc = true;
        for(int i = 1 ; i <= 8 ; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(asc && cur != i)
                asc = false;
            if(desc && cur != 9 - i)
                desc = false;
        }

        if(asc)
            System.out.println("ascending");
        else if(desc)
            System.out.println("descending");
        else
            System.out.println("mixed");

        br.close();
    }
}