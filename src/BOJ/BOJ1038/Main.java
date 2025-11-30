package BOJ.BOJ1038;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static long[] combi;
    static List<Long> list;

    public void DFS(int s, int L, int numLen) {

        if (L == numLen) {
            long num = 0;
            for (int i = combi.length - 1; i >= 0; i--) {
                num = num * 10 + combi[i];
            }
            list.add(num);
            return;
        }

        for (int i = s; i < 10; i++) {
            combi[L] = i;
            DFS(i + 1, L + 1, numLen);
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            combi = new long[i];
            T.DFS(0, 0, i);
        }
        Collections.sort(list);

        if (N > list.size() - 1) {
            System.out.println(-1);
        }
        else {
            System.out.println(list.get(N));
        }
    }
}
