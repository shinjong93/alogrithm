package boj_2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
		static int N;
		static int M;
		static int[] arr;
		static int ans;
		
		public static void main(String[] args) {
			sc.init();
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N+1];
			ans = 0;
			
			
			for(int i = 1; i < N+1; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i = 1; i < N+1; i++) {
				int tmp = 0;
				for(int j = i; j < N+1; j++) {
					tmp += arr[j];
					if(tmp == M) {
						ans++;
						break;
					}
				}
			}
			System.out.println(ans);
		}
		
		static class sc {
	        private static BufferedReader br;
	        private static StringTokenizer st;

	        static void init() {
	            br = new BufferedReader(new InputStreamReader(System.in));
	            st = new StringTokenizer("");
	        }

	        static String readLine() {
	            try {
	                return br.readLine();
	            } catch (IOException e) {
	            }
	            return null;
	        }

	        static String readLineReplace() {
	            try {
	                return br.readLine().replaceAll("\\s+", "");
	            } catch (IOException e) {
	            }
	            return null;
	        }

	        static String next() {
	            while (!st.hasMoreTokens()) {
	                try {
	                    st = new StringTokenizer(br.readLine());
	                } catch (IOException e) {
	                }
	            }
	            return st.nextToken();
	        }

	        static boolean hasNext() {
	            return st.hasMoreTokens();
	        }

	        static long nextLong() {
	            return Long.parseLong(next());
	        }

	        static int nextInt() {
	            return Integer.parseInt(next());
	        }

	        static double nextDouble() {
	            return Double.parseDouble(next());
	        }
	    }
}
