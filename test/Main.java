package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 2748번 피보나치 2.
 * */

public class Main {
	
	static long[] fibo;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		fibo = new long[N+1];
		fibo[0] = 0;
		fibo[1] = 1;
		
		for(int i = 2; i < N +1; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		System.out.println(fibo[N]);
	}
	

}
