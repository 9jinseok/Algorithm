import java.io.*;
import java.util.StringTokenizer;

class Main_2615_오목 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = 19;
		int[][] map = new int[N][N];
		int[] dx = {-1,0,1,1}, dy = {1,1,1,0};
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int resX = -1, resY = -1;
		int res = 0;
		boolean end = false;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] != 0) {
					int num = map[i][j];
					for(int d = 0 ; d < 4 ; d++) {
						int prevX = i - dx[d], prevY = j - dy[d];
						if( prevX >= 0 && prevX < N && prevY >= 0 && prevY < N && map[prevX][prevY] == num)
							continue;
						boolean chk = false;
						for(int k = 1 ; k < 5 ; k++) {
							int x = i + dx[d]*k, y = j + dy[d]*k;
							if( x < 0 || x >= N || y < 0 || y >= N || map[x][y] != num)
								break;
							if( k == 4 )
								chk = true;
						}
						if(chk) {
							int x = i + dx[d] * 5, y = j + dy[d] * 5;
							if( x < 0 || x >= N || y < 0 || y >= N || map[x][y] != num) {
								res = num;
								resX = i + 1;
								resY = j + 1;
								end = true;
								break;
							}
						}
					}
				}
				if(end)
					break;
			}
			if(end)
				break;
		}
		
		bw.write(res + "\n");
		if(res != 0)
			bw.write(resX + " " + resY + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}

}