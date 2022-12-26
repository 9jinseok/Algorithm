import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main_10757 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger a = new BigInteger(st.nextToken());
		BigInteger b = new BigInteger(st.nextToken());
		
		bw.write(a.add(b) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
