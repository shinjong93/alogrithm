package SURVIVOR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    static int Case;
    static int N;
    static int[][] board;
    static int[] dx = {0,-1,1,0,0,-1,1,-1,1};
    static int[] dy = {0,0,0,-1,1,1,-1,-1,1};
    static boolean[] check = {false,false,false};
    static int ans;

    public static void main(String[] args){
        sc.init();
        Case = sc.nextInt();
        for(int i = 0;  i< Case; i++){
            N = sc.nextInt();
            board = new int[N][N];
            ans = 0;

            for(int y = 0; y < N; y++){
                for(int x = 0; x < N; x++){
                    board[x][y] = sc.nextInt();
                }
            }

            for(int y = 0; y < N; y++){
                for(int x = 0; x < N; x++){
                    for(int k = 0; k < 9; k++){
                        if(x+dx[k] < 0 || y+dy[k] <0 || x + dx[k] >= N || y + dy[k] >= N)
                            continue;
                        int resident = board[x+dx[k]][y+dy[k]];
                        if(resident == 0 ){
                            reset();
                            break;
                        } else {
                            check[resident-1] = true;
                        }
                    }
                    if(check[0] == true && check[1] == true && check[2] == true)
                        ans++;
                    reset();
                }
            }
            System.out.println("#" + (i+1) + " " +  ans);
        }
    }

    static void reset(){
        for(int i = 0; i < 3; i++)
            check[i] = false;
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
