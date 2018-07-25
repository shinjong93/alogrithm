package CONSULTING;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class source {
    static int Case, Customer, minTime, totalTime;
    static int[] custTime;
    static int[] Negative;
    static int[] Q = {0,0,0};
    static int[] DP;


    public static void main(String[] args){
        sc.init();
        Case = sc.nextInt();
        for(int i= 1; i < Case+1; i++){
            Customer = sc.nextInt();
            minTime = sc.nextInt();
            totalTime = sc.nextInt();
            custTime = new int[Customer];
            Negative = new int[Customer];
            DP = new int[Customer];

            for(int j = 0; j < Customer; j++){
                custTime[j] = sc.nextInt();
                Negative[j] = sc.nextInt();
            }

            for(int j = 1; j < Customer+1; j++){
                solve(j);
            }

            for(int j = 0; j < DP.length - 1; j++){
              //  System.out.println(DP[j]);
                if(DP[j] > DP[j+1]){
                    System.out.println("#" + i + " " +  DP[j]);
                    return;
                }

            }
        }
    }

    static void solve(int k){
        int score = k * 10;
       reset();
        for(int i = 0; i < k; i++){
            int idx = Negative[i] - 1;
            Q[idx] += custTime[i] - minTime;
        }

        if(work(k) > totalTime){
            int overTime = work(k) - totalTime;
           // System.out.println("k   :  " + k + "  overtime :    " + overTime);
            for(int i = 0; i < 3; i++){
                if(overTime > Q[i]){
                    score -= Q[i] + (i+1);
                    overTime = overTime - Q[i];
                } else {
                    score -= (i+1) * overTime;
                    overTime = 0;
                }
            }
        }
        DP[k-1] = score;
    }

    static int work(int k){
        int ans = 0;
        for(int i = 0; i < k; i++){
            ans += custTime[i];
        }
        return ans;
    }

    static void reset(){
        for(int i = 0; i < 3; i++){
            Q[i] = 0;
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
