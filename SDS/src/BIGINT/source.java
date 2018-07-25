package BIGINT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/*
* 가용 가능한 더하기 -> P
* 가용 가능한 빼기 -> M
* (첫수 제외하고)
* 음수의 갯수 -> NON
* 양수의 갯수 -> NOP
* 라고 할때
*
* 1) 첫수 + 나머지 혹은 2) 첫수 - 나머지 둘 중에 최대가 되는 것을 출력.
* 1)번 케이스의 경우 M = M
* 2)번 케이스의 경우 M = M-1
*
*
* 공통적으로 음수의 갯수와 가용 가능한 빼기 크기 차이로 관련됨.
*
* M <= NON 일경우
* 정렬하고 0부터 M-1까지 양수로 전환하고 전부 더하기.
* M > NON 일경우
* 절댓값 정렬하고, 0부터 (M-NON)-1까지 음수로 바꾸고 전부 더한다.
*
* 일단 틀렸음. 경우의 수 4가지니까 잘 생각해볼것.
*
* 수열에 0이 들어있을 경우를 생각해보자 -> 0에 마이너스를 할당하는 것이 전체 크기에 도움이 되는 경우가 있는지?
* */

public class source {
    static int Case,N,P,M;
    static int First;
    static int[] Numbers;
    static int[] absNumbers;
    static long ans;
    static int NumberOfPositiveNumbers;
    static int NumberOfNegativeNumbers;

    public static void main(String[] args){
        sc.init();
        Case = sc.nextInt();
        for(int i = 1; i < Case+1; i++){
            N = sc.nextInt();
            P = sc.nextInt();
            M = sc.nextInt();
            Numbers = new int[N-1];
            absNumbers = new int[N-1];
            ans = 0;
            NumberOfPositiveNumbers = 0;
            NumberOfNegativeNumbers = 0;
            First = sc.nextInt();
            for(int idx = 0; idx < N-1; idx++){
                int input = sc.nextInt();
                if(input >= 0)
                    NumberOfPositiveNumbers++;
                else
                    NumberOfNegativeNumbers++;
                Numbers[idx] = input;
                absNumbers[idx] = Math.abs(input);
            }
            solve();
            System.out.println("#" + i + " " +  (ans+First));
        }
    }

    static void solve(){
        long result1 = 0;
        long result2 = 0;
        if(NumberOfNegativeNumbers >= M){
            Arrays.sort(Numbers);
            for(int i = 0; i < N-1; i++){
                if(i < M)
                   result1 += Numbers[i] * -1;
                else
                    result1 += Numbers[i];
            }
        } else {//NumberOfNegaviteNumbers < M
            //int tmp = M - NumberOfNegativeNumbers;
            Arrays.sort(Numbers);
            for(int i = 0; i < N-1; i++){
                if(i < M)
                    result1 += Numbers[i] * -1;
                else
                    result1 += Numbers[i];
            }
        }

    /*    if(NumberOfNegativeNumbers >= M-1){
            Arrays.sort(Numbers);
            for(int i = 0; i < N-1; i++){
                if(i < M-1)
                    result2 += Numbers[i] * -1;
                else
                    result2 += Numbers[i];
            }
        } else {//NumberOfNegaviteNumbers < M-1
            int tmp = (M-1) - NumberOfNegativeNumbers;
            Arrays.sort(absNumbers);
            for(int i = 0; i < N-1; i++){
                if(i < tmp)
                    result2 += Numbers[i] * -1;
                else
                    result2 += Numbers[i];
            }
        }*/
       // System.out.println("result1 is "+result1 + "   result2 is " + result2);
        ans = result1;
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
