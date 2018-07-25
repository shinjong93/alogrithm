package TREASURE;

    import java.io.IOException;
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;
    import java.util.LinkedList;

    public class source {
        static int Case,N,M,K;
        static LinkedList<Integer>[] arr;
        static int[] DP;
        static boolean[] visit;
        static int MIN = 987654321;

        public static void main(String[] args){
            sc.init();
            Case = sc.nextInt();
            for(int i = 1; i < Case +1 ; i++) {
                N = sc.nextInt();//유적의 갯수
                M = sc.nextInt();//단서의 갯수
                K = sc.nextInt();//화산 폭발 시간
                arr = new LinkedList[N+1];
                DP = new int[N+1];
                visit = new boolean[N+1];

                for (int j = 1; j < N + 1; j++) {
                    arr[j] = new LinkedList<Integer>();
                    DP[j] = MIN;
                    visit[j] = false;
                }

                for (int j = 0; j < M; j++) {
                    int A = sc.nextInt();
                    int B = sc.nextInt();
                    arr[A].add(B);
                }

                DP[1] = 0;
                visit[1] = true;
                solve(1);

               // for(int k = 1; k < N +1; k++){
                 // System.out.println("CASE ="+i+" DP["+k+"] is visited?  " + visit[k]);
                 // System.out.println("CASE ="+i+" DP["+k+"]'s time?  " + DP[k]);
                 // System.out.println();
               // }

              //  System.out.println();

                if(!visit[N] || DP[N] > K)
                    DP[N] = -1;
                System.out.println("#" + i + " " + DP[N]);
            }
        }

        static void solve(int start){
            for(int i = 0; i < arr[start].size(); i++){
                int next = arr[start].get(i);
                if ((visit[next] || DP[start] >= K) && next != N) {
                    continue;
                } else if(next == N){
                    DP[next] = Math.min(DP[next],DP[start])+1;
                    visit[next] = true;
                } else {
                    DP[next] = Math.min(DP[next],DP[start])+1;
                    visit[next] = true;
                    solve(next);
                }
               // System.out.println("cur DP   =>  DP["+start+"]   =  " + DP[start]);
              //  System.out.println("next DP  =>  DP["+next+"]    =  " + DP[next]);
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
