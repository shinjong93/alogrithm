package CALCULATOR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {

    static int Case;
    static int N;
    static long arr[];
    static long ans;


    public static void main(String[] args){
        sc.init();
        Case = sc.nextInt();
        for(int i = 1; i < Case +1; i++){
            N =sc.nextInt();
            arr = new long[N];
            ans = 0;
            for(int j = 0; j < N; j++){
                arr[j] = sc.nextInt();
            }


            ans = solve(arr,N,0);

            System.out.println("#" + i + " " +  ans);
        }
    }
    static long solve(long[] arr,int N,long result) {
        if (N == 1)
            return result;
        Arrays.sort(arr);
        long[] tmp;
        int next;
        if (N % 2 == 0) {
            tmp = new long[N / 2];
            next = N/2;
            for(int i = 0; i < next; i++){
                long plus = arr[2*i] + arr[2*i+1];
                tmp[i] = plus;
                result += plus;
            }
        } else {
            tmp = new long[N/2 + 1];
            next = N/2 + 1;
            tmp[N/2] = arr[N-1];
            for(int i = 0; i < next-1; i++){
                long plus = arr[2*i] + arr[2*i+1];
                tmp[i] = plus;
                result += plus;
            }
        }
        return solve(tmp, next, result);
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
