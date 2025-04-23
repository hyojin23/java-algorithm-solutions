package Recommended_Problems.DFS_BFS.BOJ1759;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static int[] combi;
    static char[] arr;
    static int L, C, vCnt, cCnt;

    public void DFS(int lv, int s) {

        if (lv == L) {
            if (vCnt < 1 || cCnt < 2) {
                return;
            }
            for (int x : combi) {
                System.out.print(arr[x]);
            }
            System.out.println();
        }
        else {
            for (int i = s; i < arr.length; i++) {
                if (lv == 0) {
                    vCnt = 0;
                    cCnt = 0;
                }
                combi[lv] = i;
                if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                    vCnt++;
                }
                else {
                    cCnt++;
                }
                DFS(lv + 1, i + 1);
                if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                    vCnt--;
                }
                else {
                    cCnt--;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();
        combi = new int[L];
        arr = new char[C];
        for (int i = 0; i < C; i++) {
            arr[i] = sc.next().charAt(0);
        }
        Arrays.sort(arr);
        T.DFS(0, 0);
    }
}
