import java.io.*;
import java.util.*;

class Main_1331_나이트투어_고진석{
	
	static boolean[][] board = new boolean[6][6];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String tmp = br.readLine();
		int x = tmp.charAt(0) - 'A';
		int y = tmp.charAt(1) - '1';
		board[x][y] = true;
		
		int sx = x;
		int sy = y;
		String res = "Valid";
		for(int i = 1 ; i < 36 ; i++) {
			tmp = br.readLine();
			int nx = tmp.charAt(0) - 'A';
			int ny = tmp.charAt(1) - '1';
			if(board[nx][ny] || (!(Math.abs(nx - x) == 1 && Math.abs(ny - y) == 2) && !(Math.abs(nx - x) == 2 && Math.abs(ny - y) == 1))) {
				res = "Invalid";
				break;
			}
			board[nx][ny] = true;
			x = nx;
			y = ny;
		}
		
		if(!(Math.abs(sx - x) == 1 && Math.abs(sy - y) == 2) && !(Math.abs(sx - x) == 2 && Math.abs(sy - y) == 1))
			res = "Invalid";
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}