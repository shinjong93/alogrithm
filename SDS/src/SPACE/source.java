package SPACE;

/*
 * 시작점 -> 도착점 최단 이동 횟수 찾기.
 * 좌표 평면의 X 길이를 N, Y 길이를 M 이라 하고
 * 시작점과 도착점간의 x좌표 차이를 a, y좌표 차리를 b라고 한다.
 * 이동회수이므로 모든 값은 절댓값을 취한다.
 * 또한 좌표 평면을 초과하여 반대쪽으로 이동함을 초과한다 라고 칭하면,
 * 시작점 -> 도착점까지 이동하는 경우의 수는 총 4가지.
 * 1. 단순 a+b
 * 2. y좌표를 초과한 뒤 수평이동하는 a +|Y - b|
 * 3. x좌표를 초과한 뒤 수직이동하는 |X - a| + b
 * 4. x,y좌표 모두 초과하여 이동하는 |X - a| + |Y - b|
 * 이상 4가지 중 최소값을 출력한다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class source {
    static int N;
    static int M;
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static int Case;


    public static void main(String[] args){
        sc.init();
        Case = sc.nextInt();
        for(int i = 1; i < Case+1; i++){
            N = sc.nextInt();
            M = sc.nextInt();
            startX = sc.nextInt();
            startY = sc.nextInt();
            endX = sc.nextInt();
            endY = sc.nextInt();
            System.out.println("#" + i + " " +  solve2());
        }
    }

    static int solve2(){
        int MIN = 987654321;
        int[] tmp = new int[4];
        int a = Math.abs(startX -endX);
        int b = Math.abs(startY - endY);

        tmp[0] = a+b;
        tmp[1] = Math.abs(M-b) + a;
        tmp[2] = Math.abs(N-a) + b;
        tmp[3] = Math.abs(N-a) + Math.abs(M-b);

        for(int result : tmp){
            if(result < MIN)
                MIN = result;
        }
        return MIN;
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
