import java.io.*;
import java.util.*;

class Solution_1873_상호의배틀필드_고진석 {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(br.readLine());
    	for(int t = 1 ; t <= T ; t++) {
    		st = new StringTokenizer(br.readLine());
    		int H = Integer.parseInt(st.nextToken());
    		int W = Integer.parseInt(st.nextToken());
    		
    		String[] map = new String[H];
    		int dir = -1;
    		int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    		int x = -1, y = -1;
    		for(int i = 0 ; i < H ; i++) {
    			map[i] = br.readLine();
    			for(int j = 0 ; j < W ; j++) {
    				char here = map[i].charAt(j);
    				if(here == '^') {
    					x = i;
    					y = j;
    					dir = 0;
    				}
    				else if(here == 'v') {
    					x = i;
    					y = j;
    					dir = 1;    					
    				}
    				else if(here == '<') {
    					x = i;
    					y = j;
    					dir = 2;    					
    				}
    				else if(here == '>') {
    					x = i;
    					y = j;
    					dir = 3;    					
    				}
    			}
    		}
    		
    		br.readLine();
    		String s = br.readLine();
    		
    		for(char c : s.toCharArray()) {
				String here = "";
    			switch(c) {
	    			case 'S':
	    				int sx = x + dx[dir], sy = y + dy[dir];
	    				while(sx >= 0 && sx < H && sy >= 0 && sy < W) {
	    					if(map[sx].charAt(sy) == '*') {
	    						map[sx] = map[sx].substring(0, sy) + "." + map[sx].substring(sy + 1);
	    						break;
	    					}
	    					else if(map[sx].charAt(sy) == '#')
	    						break;
	    					sx += dx[dir];
	    					sy += dy[dir];
	    				}
	    				
	    				break;
	    			case 'U':
	    				dir = 0;
						here += "^";
	    				break;
	    			case 'D':
	    				dir = 1;
						here += "v";
	    				break;
	    			case 'L':
	    				dir = 2;
						here += "<";
	    				break;
	    			case 'R':
	    				dir = 3;
						here += ">";
	    				break;
    			}
    			if(!here.equals("")) {
	    			int nx = x + dx[dir];
					int ny = y + dy[dir];
					if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx].charAt(ny) == '.'){
						map[x] = map[x].substring(0, y) + "." + map[x].substring(y + 1);
						x = nx;
						y = ny;
					}
					map[x] = map[x].substring(0, y) + here + map[x].substring(y + 1);
    			}
    		}
    		
    		bw.write("#" + t + " ");
    		for(int i = 0 ; i < H ; i++)
    			bw.write(map[i] + "\n");
    	}
    	bw.flush();
    	bw.close();
    	br.close();
    	
    }
}