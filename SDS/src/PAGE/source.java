package PAGE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    static int Case,N,S,J,R;
    static int[] rest;

    public static void main(String[] args){
        sc.init();
        Case = sc.nextInt();
        for(int i = 1; i < Case+1; i++){
            N = sc.nextInt();
            S = sc.nextInt();
            J = sc.nextInt();
            R = sc.nextInt();
            rest = new int[R];
            int ans = 0;
            for(int k = 0; k < R; k++){
                rest[k] = sc.nextInt();
            }

            for(int k = 0; k*(J+1)+S <= N; k++){
                int page = k*(J+1) + S;
                for(int j = 0; j < R; j++){
                    if(page > rest[j])
                        continue;
                    else if(page == rest[j])
                        ans++;
                }
            }
            System.out.println("#" + i + " " +  ans);
        }
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
