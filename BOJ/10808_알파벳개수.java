import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10808_알파벳개수
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[] input = br.readLine().toCharArray();
        int[] arr = new int[26];

        for(int i = 0 ; i < input.length ; i++)
            arr[input[i] - 'a']++;

        for(int i = 0 ; i < 26 ; i++)
            System.out.print(arr[i] + " ");

        br.close();
    }
}