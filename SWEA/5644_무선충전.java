import java.io.*;
import java.util.*;

class Solution_5644_무선충전_고진석 {
	static int ans = 0;
	static int[] dx = {0,-1,0,1,0}, dy = {0,0,1,0,-1};
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			int[] aMove = new int[M];
			int[] bMove = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M ; i++)
				aMove[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M ; i++)
				bMove[i] = Integer.parseInt(st.nextToken());
			
			int[][] BC = new int[A][4];
			for(int i = 0 ; i < A ; i++) {
				st = new StringTokenizer(br.readLine());
				BC[i][1] = Integer.parseInt(st.nextToken()) - 1;
				BC[i][0] = Integer.parseInt(st.nextToken()) - 1;
				BC[i][2] = Integer.parseInt(st.nextToken());
				BC[i][3] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			int ax = 0, ay = 0, bx = 9, by = 9;
			charge(BC, ax, ay, bx, by);
			for(int i = 0 ; i < M ; i++) {
				ax += dx[aMove[i]];
				ay += dy[aMove[i]];
				bx += dx[bMove[i]];
				by += dy[bMove[i]];
				charge(BC, ax, ay, bx, by);
			}
			
			bw.write("#" + t + " " + ans + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
    }
    
    public static void charge(int[][] BC, int ax, int ay, int bx, int by) {
    	List<Integer> aList = new ArrayList<>();
    	List<Integer> bList = new ArrayList<>();
    	for(int i = 0 ; i < BC.length ; i++) {
    		if(Math.abs(ax - BC[i][0]) + Math.abs(ay - BC[i][1]) <= BC[i][2])
    			aList.add(i);
    		if(Math.abs(bx - BC[i][0]) + Math.abs(by - BC[i][1]) <= BC[i][2])
    			bList.add(i);
    	}
    	
    	int max = 0;
    	if(aList.size() == 0) {
    		if(bList.size() == 0)
    			return;
    		else {
    			for(int i = 0 ; i < bList.size() ; i++)
    				max = Math.max(max, BC[bList.get(i)][3]);
    		}
    	}
    	else if(bList.size() == 0)
    		for(int i = 0 ; i < aList.size() ; i++)
				max = Math.max(max, BC[aList.get(i)][3]);
    	else {
    		for(int i = 0 ; i < aList.size() ; i++)
    			for(int j = 0 ; j < bList.size() ; j++) {
    				if(aList.get(i) == bList.get(j))
    					max = Math.max(max, BC[aList.get(i)][3]);
    				else
    					max = Math.max(max, BC[aList.get(i)][3] + BC[bList.get(j)][3]);
    			}
    	}
    	ans += max;
    }
}
