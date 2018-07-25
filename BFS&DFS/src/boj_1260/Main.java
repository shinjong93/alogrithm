import java.util.*;
import java.io.*;

public class Main{
	static int nV;
	static int nE;
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{

	String[] s = in.readLine().split(" ");
		
	nV = Integer.parseInt(s[0]) + 1;
	nE = Integer.parseInt(s[1]) + 1;
	int start = Integer.parseInt(s[2]);

	ArrayList<ArrayList<Integer>> ad = new <ArrayList<Integer>> ArrayList();
	int[] visit = new int[nV];
	java.util.Arrays.fill(visit,0);


	for(int i = 0 ; i < nV; i++){
		ad.add(new<Integer> ArrayList());
	}

	for(int i = 1 ; i < nE; i++){
		int a = 0;
		int b = 0;
		s = in.readLine().split(" ");
		a = Integer.parseInt(s[0]);
		b = Integer.parseInt(s[1]);
	
		ad.get(a).add(b);
		ad.get(b).add(a);
	}

		BFS(ad,visit,start);
		System.out.println();
		DFS(ad,visit,start);
		in.close();
		out.close();
	}
	public static void BFS(ArrayList<ArrayList<Integer>> n, int[] visit,int start) throws Exception{
		visit[start] = 1;
		ArrayList<Integer> tmp = n.get(start);
		System.out.print(start + " ");
		Collections.sort(tmp);
	//	out.write(start + " ");
		for(int i = 0; i < tmp.size(); i++){
			if(visit[tmp.get(i)] != 1){
				BFS(n , visit, tmp.get(i));
			}
		}
	}

	public static void DFS(ArrayList<ArrayList<Integer>> n, int[] visit, int start) throws Exception{
		java.util.Arrays.fill(visit,0);
		visit[start] = 1;
		ArrayList<Integer> tmp;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		while(!q.isEmpty()){
			int now = q.remove();
			tmp = n.get(now);
			Collections.sort(tmp);
			System.out.print(now + " ");
			for(int i = 0; i < tmp.size(); i++){
				if(visit[tmp.get(i)] != 1){
						q.add(tmp.get(i));
						visit[tmp.get(i)] = 1;
				}
			}
	}
}
}
