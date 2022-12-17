import java.io.*;

class Main_2239_스도쿠_고진석 {
	static int N = 9;
	static int[][] board = new int[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int start = -1;
		
		for(int i = 0 ; i < N ; i++) {
			String line = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				board[i][j] = line.charAt(j) - '0';
				if(start == -1 && board[i][j] == 0)
					start = i * N + j;
			}
		}
		
		sudoku(start);
		br.close();
	}
	
	public static void sudoku(int idx) throws IOException {
		if(idx >= N * N) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++)
					bw.write(board[i][j] + "");
				bw.write("\n");
			}
			bw.flush();
			bw.close();
			System.exit(0);
		}
		
		int r = idx / N;
		int c = idx % N;
		if(board[r][c] == 0) {
			boolean[] used = new boolean[N + 1];
			for(int i = 0 ; i < N ; i++) {
				used[board[i][c]] = true;
				used[board[r][i]] = true;
			}
			
			int startR = r - r % 3;
			int startC = c - c % 3;
			
			for(int i = 0 ; i < 3 ; i++)
				for(int j = 0 ; j < 3 ; j++)
					used[board[startR+i][startC+j]] = true;
			
			for(int i = 1 ; i <= N ; i++) {
				if(used[i])
					continue;
				board[r][c] = i;
				sudoku(idx + 1);
				board[r][c] = 0;
			}
		}
		else {
			sudoku(idx + 1);
		}
	}
	
} 