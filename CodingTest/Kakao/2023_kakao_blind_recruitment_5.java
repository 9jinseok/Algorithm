import java.util.ArrayList;
import java.util.HashMap;

class _5 {
	String[][] map = new String[51][51];
	HashMap<Integer, ArrayList<Integer>> link = new HashMap<Integer, ArrayList<Integer>>();
	int r, c;
	int rr, cc;
	String v1, v2;
	
	//접근부터 틀린 듯
    public String[] solution(String[] commands) {
        String[] answer = {};
        
        for(String cmd : commands) {
        	String[] splited = cmd.split(" ");
        	switch(splited[0]) {
        		case "UPDATE":
        			if(splited.length == 4) {
        				r = Integer.parseInt(splited[1]);
        				c = Integer.parseInt(splited[2]);
        				v1 = splited[3];
        				
        				map[r][c] = v1;
        			}
        			else {
        				v1 = splited[1];
        				v2 = splited[2];
        				
        				for(int i = 1 ; i <= 50 ; i++)
        					for(int j = 1 ; j <= 50 ; j++)
        						if(map[r][c].equals(v1))
        							map[r][c] = v2;
        			}
        			break;
        		case "MERGE":
        			r = Integer.parseInt(splited[1]);
        			c = Integer.parseInt(splited[2]);
        			rr = Integer.parseInt(splited[3]);
        			cc = Integer.parseInt(splited[4]);
        			
        			int idx1 = idx(r, c);
        			int idx2 = idx(rr, cc);
        			
        			link.putIfAbsent(idx1, new ArrayList<Integer>());
        			link.putIfAbsent(idx2, new ArrayList<Integer>());
        			link.get(idx1).add(idx2);
        			link.get(idx2).add(idx1);
        			
        			break;
        		case "UNMERGE":
        			r = Integer.parseInt(splited[1]);
        			c = Integer.parseInt(splited[2]);
        			
        			idx1 = idx(r, c);
        			link.remove(idx1);
        			
        			for(ArrayList<Integer> list : link.values()) {
        				list.remove(idx1);
        			}
        			
        			break;
        		case "PRINT":
        			
        			
        			break;
        	}
        }
        
        
        return answer;
    }
    
    public int idx(int r, int c) {
    	return r*50 + c;
    }
    
    public int[] rc(int idx) {
    	int[] res = new int[2];
    	res[0] = idx / 50;
    	res[1] = idx % 50;
    	return res;
    }
}