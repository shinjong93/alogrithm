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
	


	Queue<Integer> q = new LinkedList<Integer>();
	ArrayList<Integer> tmp;
	visit[start] = 1;
	q.add(start);
		tmp = ad.get(start);
		System.out.print(start + " ");
		for(int i = 0; i < tmp.size(); i++){
			q.add(tmp.get(i));
			while(!q.isEmpty()){
				int now = q.remove();
				if(visit[now] != 1){
					q.add(ad.get(now).get(0));
					visit[now] = 1;
					System.out.print(now + " ");
				}
			}
		}
	
	System.out.println("");
	java.util.Arrays.fill(visit,0);
	q.add(start);
	visit[start] = 1;
	while(!q.isEmpty()){
		int now = q.remove();
		tmp = ad.get(now);
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
