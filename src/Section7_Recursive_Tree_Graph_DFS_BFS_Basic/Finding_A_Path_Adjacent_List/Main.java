package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Finding_A_Path_Adjacent_List;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static int n;
    static List<List<Integer>> list;
    static int[] ch;
    static int answer;

    public void DFS(int v) {

        if (v == n) {
            answer++;
        }
        else {
            List<Integer> in = list.get(v);

            for (int j : in) {
                if (ch[j] == 0) {
                    ch[j] = 1;
                    DFS(j);
                    ch[j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        ch = new int[n + 1];
        list = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            List<Integer> in = new ArrayList<>();
            list.add(in);
        }

        for (int i = 0; i < m; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            list.get(a).add(b);
        }

        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
