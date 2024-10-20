package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Finding_A_Calf;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main_4th {

    public int BFS(int s, int e) {

        Queue<Integer> q = new LinkedList<>();
        int[] ch = new int[10001];
        q.offer(s);
        int L = 0;
        while (!q.isEmpty()) {

            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();

                if (cur > 0 && cur <= 10000 && ch[cur] == 0) {
                    if (cur == e) {
                        return L;
                    }
                    else {
                        q.offer(cur + 5);
                        q.offer(cur + 1);
                        q.offer(cur - 1);
                    }
                    ch[cur] = 1;
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();

        System.out.println(T.BFS(s, e));
    }
}
