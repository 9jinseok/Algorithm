import java.io.*;
import java.util.*;

class ladder1
{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = 100;
		
		int[][] arr = new int[N][N];
		for(int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			int x = -1, y = -1;
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			
			while(x > 0) {
				while(x > 0) {
					if(y + 1 < N && arr[x][y+1] != 0)
						break;
					if(y > 0 && arr[x][y-1] != 0)
						break;
					x--;
				}
				if(y + 1 < N && arr[x][y+1] != 0) {
					--x;
					while(arr[x][++y] == 0);
				}
				else if(y > 0 && arr[x][y-1] != 0){
					--x;
					while(arr[x][--y] == 0);
				}
			}
			
			System.out.println("#" + tc + " " + y);
		}
	}
}
