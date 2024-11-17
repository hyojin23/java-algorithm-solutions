package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Finding_A_Calf;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main_5th {

    public int BFS(int s, int e) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int[] ch = new int[10001];
        ch[s] = 1;
        int L = 0;
        int[] jumps = {1, -1, 5};

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int pos = q.poll();
                if (pos == e) {
                    return L;
                }
                for (int jump : jumps) {
                    int np = pos + jump;
                    if (np >= 1 && np <= 10000 && ch[np] == 0) {
                        q.offer(np);
                        ch[np] = 1;
                    }
                }
            }
            L++;
        }
        return 0;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();

        System.out.println(T.BFS(s, e));
    }
}
