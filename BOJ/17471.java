import java.io.*;
import java.util.*;

public class Main_17471_게리맨더링_고진석 {
	static int N, ans, sum = 0;
	static int[] population;
	static int[][] adjMatrix;
	static List<Integer> aList, bList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		population = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			sum += population[i];
		}
		
		adjMatrix = new int[N + 1][N + 1];
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j < M ; j++)
				adjMatrix[i][Integer.parseInt(st.nextToken())] = 1;
		}
		
		ans = sum;
		aList = new ArrayList<Integer>();
		bList = new ArrayList<Integer>();
		divide(1);
		
		if(ans == sum)
			ans = -1;
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void divide(int depth) {
		if(depth > N)
			check();
		else {
			aList.add(depth);
			divide(depth + 1);
			aList.remove((Integer)depth);
			bList.add(depth);
			divide(depth + 1);
			bList.remove((Integer)depth);
		}
	}
	
	public static void check() {
		if(aList.size() == 0 || bList.size() == 0)
			return;
		int tmp = sum;
		for(int i : aList)
			tmp -= 2 * population[i];
		
		tmp = Math.abs(tmp);
		if(tmp >= ans)
			return;
		
		if(linked())
			ans = tmp;
	}
	
	public static boolean linked() {
		boolean chk = true;
		
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(visited, true);
		for(int i : aList)
			visited[i] = false;
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(aList.get(0));
		visited[aList.get(0)] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i = 1 ; i <= N ; i++)
				if(!visited[i] && adjMatrix[cur][i] == 1) {
					q.offer(i);
					visited[i] = true;
				}
		}
		for(int i = 1 ; i <= N ; i++)
			if(!visited[i]) {
				chk = false;
				break;
			}
		
		if(!chk)
			return chk;
		
		for(int i : bList)
			visited[i] = false;
		q.clear();
		q.offer(bList.get(0));
		visited[bList.get(0)] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i = 1 ; i <= N ; i++)
				if(!visited[i] && adjMatrix[cur][i] == 1) {
					q.offer(i);
					visited[i] = true;
				}
		}
		for(int i = 1 ; i <= N ; i++)
			if(!visited[i]) {
				chk = false;
				break;
			}
		
		return chk;
	}
}
