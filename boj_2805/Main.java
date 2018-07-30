package boj_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/*
 * Time Over err.
 * */


public class Main {
	static int N;
	static int M;
	static int[] Wood;
	static int ans;
	
	public static void main(String[] args) {
		sc.init();
		N = sc.nextInt();
		M = sc.nextInt();
		Wood = new int[N+1];
		
		for(int i = 1; i < N+1; i++) {
			Wood[i] = sc.nextInt();
		}
		Arrays.sort(Wood);
		int low = 1;
		int hi = N;
		ans = 0;
		
		while(low <= hi) {
			int tmp = 0;
			int mid = (low + hi)/2;
			for(int i = low; i < N+1; i++) {
				if(Wood[i] > Wood[mid]) {
					tmp += (Wood[i] - Wood[mid]);
					if(tmp > M) {
						low = mid;
						tmp = 0;
						break;
					}
				}
			}
			if(tmp == M) {
				ans = Wood[mid];
				break;
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
