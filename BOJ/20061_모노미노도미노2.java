import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20061_모노미노도미노2 {

    static boolean[][] blue, green;
    static int res = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        blue = new boolean[4][6];
        green = new boolean[6][4];

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            greenInput(cmd, y);
            greenReduce();

            blueInput(cmd, x);
            blueReduce();
        }

        System.out.println(res);
        int cnt = 0;
        for(int i = 0 ; i < 6 ; i++)
            for(int j = 0 ; j < 4 ; j++){
                if(green[i][j])
                    cnt++;
                if(blue[j][i])
                    cnt++;
            }
        System.out.println(cnt);
        br.close();
    }

    public static void greenInput(int cmd, int y){
        int idx;
        if(cmd != 2){
            for(idx = 2 ; idx < 6 ; idx++)
                if(green[idx][y])
                    break;
            green[idx - 1][y] = true;
            if(cmd == 3)
                green[idx - 2][y] = true;
        }
        else{
            for(idx = 2 ; idx < 6 ; idx++)
                if(green[idx][y] || green[idx][y + 1])
                    break;
            green[idx - 1][y] = true;
            green[idx - 1][y + 1] = true;
        }
    }

    public static void greenReduce(){
        int reduceCnt = 0;
        int idx = 5;
        for(int i = 5 ; i >= 0 ; i--){
            boolean allTrue = true, allFalse = true;
            for(int j = 0 ; j < 4 ; j++){
                if(green[i][j])
                    allFalse = false;
                else
                    allTrue = false;
            }
            if(allTrue)
                reduceCnt++;
            else if(!allFalse) {
                System.arraycopy(green[i],0,green[idx--],0,4);
            }
            else
                break;
        }
        while(idx >= 0)
            Arrays.fill(green[idx--], false);

        int cnt = 0;
        for(int i = 1 ; i >= 0 ; i--)
            for(int j = 0 ; j < 4 ; j++)
                if(green[i][j]) {
                    cnt++;
                    break;
                }
        for(int i = 5 ; i >= cnt ; i--){
            System.arraycopy(green[i - cnt],0,green[i],0,4);
        }
        Arrays.fill(green[0], false);
        Arrays.fill(green[1], false);

        res += reduceCnt;
    }

    public static void blueInput(int cmd, int x){
        int idx;
        if(cmd != 3){
            for(idx = 2 ; idx < 6 ; idx++)
                if(blue[x][idx])
                    break;
            blue[x][idx - 1] = true;
            if(cmd == 2)
                blue[x][idx - 2] = true;
        }
        else{
            for(idx = 2 ; idx < 6 ; idx++)
                if(blue[x][idx] || blue[x + 1][idx])
                    break;
            blue[x][idx - 1] = true;
            blue[x + 1][idx - 1] = true;
        }
    }

    public static void blueReduce(){
        int reduceCnt = 0;
        int idx = 5;
        for(int i = 5 ; i >= 0 ; i--){
            boolean allTrue = true, allFalse = true;
            for(int j = 0 ; j < 4 ; j++){
                if(blue[j][i])
                    allFalse = false;
                else
                    allTrue = false;
            }
            if(allTrue)
                reduceCnt++;
            else if(!allFalse) {
                for(int j = 0 ; j < 4 ; j++)
                    blue[j][idx] = blue[j][i];
                idx--;
            }
            else
                break;
        }
        while(idx >= 0) {
            for(int i = 0 ; i < 4 ; i++)
                blue[i][idx] = false;
            idx--;
        }

        int cnt = 0;
        for(int i = 1 ; i >= 0 ; i--)
            for(int j = 0 ; j < 4 ; j++)
                if(blue[j][i]) {
                    cnt++;
                    break;
                }
        for(int i = 5 ; i >= cnt ; i--){
            for(int j = 0 ; j < 4 ; j++)
                blue[j][i] = blue[j][i - cnt];
        }
        for(int i = 0 ; i < 4 ; i++) {
            blue[i][0] = false;
            blue[i][1] = false;
        }

        res += reduceCnt;
    }
}
