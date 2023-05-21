import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_2338_긴자리계산 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));

        br.close();
    }
}
