package CLOCK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class source {

    static int[][] MAP = {
            {1, 1, 1, 1, 1, 1, 0}, // 0
            {0, 0, 0, 0, 1, 1, 0}, // 1
            {1, 0, 1, 1, 0, 1, 1}, // 2
            {1, 0, 0, 1, 1, 1, 1}, // 3
            {0, 1, 0, 0, 1, 1, 1}, // 4
            {1, 1, 0, 1, 1, 0, 1}, // 5
            {1, 1, 1, 1, 1, 0, 1}, // 6
            {1, 0, 0, 0, 1, 1, 0}, // 7
            {1, 1, 1, 1, 1, 1, 1}, // 8
            {1, 1, 0, 1, 1, 1, 1}, // 9
    };
    static int Case;
    static int[][] input;
    static int[] time;
    static int seg;
    static int broken;


    public static void main(String[] args){
        sc.init();
        Case = sc.nextInt();
        for(int i = 1; i < Case + 1; i++){
            input = new int[4][7];
            seg = 0;
            broken = 0;
            time = new int[4];
            Arrays.fill(time,-1);
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 7; k++){
                    input[j][k] = sc.nextInt();
                }
            }




            for(int x = 0; x < 4; x++){
                for(int y = 0; y < 10; y++){
                    if(Arrays.equals(MAP[y],input[x]))
                        time[x] = y;
                }
                if(time[x] < 0){
                    broken++;
                }
            }

            for(int x = 0; x < 4; x++){
                if(time[x] < 0)
                    fix(input[x],x);
            }

            solveTimes();

            System.out.print("#" + i + " ");
            for(int k = 0; k < 4; k++){
                if(time[0] == 0 && k == 0)
                    k++;
                if(time[2] == 0 && k == 2)
                    k++;

                System.out.print(time[k]);

                if(k == 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void solveTimes(){
        int[] tmp = new int[3];
        int total = 0;
        if(time[0] > 2){
            tmp[0] = 1;
            total++;
        }
        if(time[0] == 2 && time[1] > 4){
            tmp[1] = 1;
            total++;
        }
        if(time[2] > 5){
            tmp[1] = 1;
            total++;
        }

        for(int i = 0 ; i < 3; i++){
            if(tmp[i] == 1){
                if(total > 1){
                    seg+=1;
                    solveHour(i);
                    seg-=1;
                    total--;
                } else if(total == 1){
                    solveHour(i);
                }
            }
        }
        for(int i = 0; i < 4; i++){
            solveHour(i);
        }
    }

    static void solveHour(int i){
            if(seg == 2)
                return;
            if(time[i] == 3 || time[i] == 4 || time[i] == 5 || time[i] == 6 || time[i] == 7 || time[i] == 8 || time[i] == 9){
                if(seg == 0){
                    if(time[i] == 3){
                        time[i] = 2;
                        seg += 2;
                    } else if(time[i] == 4) {
                        time[i] = 1;
                        seg += 2;
                    } else if(time[i] == 5){
                        time[i] = 3;
                        seg += 2;
                    }
                    else if(time[i] == 6){
                        time[i] = 0;
                        seg += 2;
                    } else if(time[i] == 7){
                        time[i] = 1;
                        seg += 1;
                    } else if(time[i] == 8){
                        time[i] = 0;
                        seg += 1;
                    } else if(time[i] == 9){
                        time[i] = 0;
                        seg += 2;
                    }
                } else if(seg == 1){
                    if(time[i] == 7){
                        time[i] = 1;
                        seg += 1;
                    } else if(time[i] == 8){
                        time[i] = 0;
                        seg += 1;
                    } else if(time[i] == 6){
                        time[i] = 5;
                        seg += 1;
                    } else if(time[i] == 9){
                        time[i] = 8;
                        seg += 1;
                    }
                }
            }
    }

    static void fixer(int idx, int i, int same){
        if(broken == 1){
            if(same == 5 && seg == 0){
                time[idx] = i;
                seg += (7-same);
                broken--;
            } else if(same == 6 && seg > 0){
                time[idx] = i;
                seg += 1;
                broken--;
            }
        } else {
            if(same == 6){
                time[idx] = i;
                seg+= 1;
                broken--;
            }
        }
    }

    static void fix(int[] target, int idx){
        int same = 0;
        for(int i = 0; i < 10; i++ ){
            for(int j = 0; j < 7; j++){
                if(MAP[i][j] == target[j]){
                    same++;
                }
                if(idx == 0 && i < 3){
                    fixer(idx,i,same);
                } else if(idx == 1){
                    if(time[idx-1] == 2 && i < 4){
                        fixer(idx,i,same);
                    } else if(time[idx-1] < 2){
                        fixer(idx,i,same);
                    }
                } else if(idx == 2 && i < 6){
                    fixer(idx,i,same);
                } else if(idx == 3){
                    fixer(idx,i,same);
                }
            }
            same = 0;
        }
        if(broken == 0)
            return;
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

// 0 0 0 0 1 1 0 1 0 0 0 1 1 0 0 0 0 0 1 1 0 1 1 1 1 1 1 1
// 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 0 0 1 1 0 0 0 0 0 1 1 0  >> 없음 1 : 11 --> 11:11
// 1 1 1 1 1 1 0 1 1 1 1 1 1 0 1 1 1 1 1 1 0 1 1 1 1 1 1 0  >> 00 : 00 --> 00 : 00
// 0 0 0 0 1 1 0 0 1 0 0 1 1 1 0 1 0 0 1 1 1 1 0 0 0 1 1 0 >> 14:47 --> 11:47
// 0 0 0 0 1 1 0 1 1 1 1 1 1 0 0 0 0 0 1 1 0 1 0 1 1 0 1 0 >> 10:1X -->
// 0 0 0 0 1 1 0 0 1 1 1 1 0 1 0 1 0 0 1 1 0 1 1 1 1 1 1 0 >> 1X : X0 --> 16:10

/*
* 28개의 세그로 4개의 수를 만들어 시간을 표시.
*
* 거쳐야할 단계는 3가지.
*
* 1) 아예 숫자가 아니게 망가진 경우.
* 2) 각 자리의 범위에서 벗어난 경우.
* 3) 현재 보이는 수에서 변형가능한 지금보다 작은 수.
*
* 숫자 0 / 1 / 2 는 더 작은 수로 변형이 불가능.
*
* 1) - 2)번은 조건을 따로 두고 풀 수 없으므로 하나로 풀어야 하나?
* 3)번 
*
* */