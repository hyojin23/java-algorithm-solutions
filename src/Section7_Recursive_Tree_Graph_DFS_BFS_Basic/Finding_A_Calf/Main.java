package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Finding_A_Calf;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public int BFS(int s, int e) {

        int[] jumps = {1, -1, 5};
        int[] ch = new int[10001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        ch[s] = 1;
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int pos = q.poll();
                for (int j = 0; j < jumps.length; j++) {
                    int np = pos + jumps[j];
                    if (np == e) {
                        return L + 1;
                    }
                    if (np > 0 && ch[np] == 0) {
                        q.offer(np);
                        ch[np] = 1;
                    }
                }
            }
            L++;
        }
        return L;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.BFS(s, e));
    }
}
