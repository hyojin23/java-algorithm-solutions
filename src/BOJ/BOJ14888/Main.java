package BOJ.BOJ14888;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int totCnt;
    static int[] arr, ch;
    static List<Character> opList;


    public void DFS(int L, int sum) {

        if (L == N - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        else {
            for (int i = 0; i < totCnt; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    char operator = opList.get(i);
                    if (operator == '+') {
                        DFS(L + 1, sum + arr[L + 1]);
                    }
                    else if (operator == '-') {
                        DFS(L + 1, sum - arr[L + 1]);
                    }
                    else if (operator == '*') {
                        DFS(L + 1, sum * arr[L + 1]);
                    }
                    else {
                        if (sum < 0) {
                            DFS(L + 1, -((sum * -1) / arr[L + 1]));
                        }
                        else {
                            DFS(L + 1, sum / arr[L + 1]);
                        }
                    }
                    ch[i] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        opList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            int opCnt = sc.nextInt();
            totCnt += opCnt;
            for (int j = 0; j < opCnt; j++) {
                if (i == 0) {
                    opList.add('+');
                }
                else if (i == 1) {
                    opList.add('-');
                }
                else if (i == 2) {
                    opList.add('*');
                }
                else {
                    opList.add('/');
                }
            }
        }
        ch = new int[totCnt];
        T.DFS(0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
}
