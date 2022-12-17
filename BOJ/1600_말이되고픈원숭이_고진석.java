import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_1600_말이되고픈원숭이_고진석 {
	static int K, W, H;
	static boolean[][][] visited;
	static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
	static int[][] ddx = {{-2,-2},{-1,1},{2,2},{-1,1}}, ddy = {{-1,1},{-2,-2},{-1,1},{2,2}}; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		visited = new boolean[K + 1][H][W];
		for(int i = 0 ; i < H ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < W ; j++)
				if(Integer.parseInt(st.nextToken()) == 1)
					for(int k = 0 ; k <= K ; k++)
						visited[k][i][j] = true;
		}

		Queue<int[]> q = new ArrayDeque<>();
		visited[0][0][0] = true;
		q.add(new int[] {0,0,0,0});

		int res = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == H - 1 && cur[1] == W - 1) {
				res = Math.min(res, cur[3]);
			}
			else {
				for(int d = 0 ; d < 4 ; d++) {
					if(cur[2] < K) {
						for(int dd = 0 ; dd < 2 ; dd++) {
							int nnx = cur[0] + ddx[d][dd];
							int nny = cur[1] + ddy[d][dd];
							if(isIn(nnx, nny) && !visited[cur[2] + 1][nnx][nny]) {
								visited[cur[2] + 1][nnx][nny] = true;
								q.add(new int[] {nnx,nny,cur[2] + 1, cur[3] + 1});
							}
						}
					}
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					if(isIn(nx,ny) && !visited[cur[2]][nx][ny]) {
						visited[cur[2]][nx][ny] = true;
						q.add(new int[] {nx, ny, cur[2], cur[3] + 1});
					}
				}
			}
		}

		if(res == Integer.MAX_VALUE)
			res = -1;
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean isIn(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W; 
	}
} 