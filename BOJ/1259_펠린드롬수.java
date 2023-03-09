import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1259_펠린드롬수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while(!(input = br.readLine()).equals("0")){
            char[] n = input.toCharArray();
            int start = 0, end = n.length - 1;
            boolean chk = true;

            while(start < end){
                if(n[start] != n[end]){
                    chk = false;
                    break;
                }
                start++;
                end--;
            }

            if(chk)
                bw.write("yes\n");
            else
                bw.write("no\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}