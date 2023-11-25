package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Finding_A_Calf;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> q = new LinkedList<>();

    public int BFS(int s, int e) {

        ch = new int[10001];
        ch[s] = 1;
        q.offer(s);
        int L = 0;

        while (!q.isEmpty()) {

            int len = q.size();

            for (int i = 0; i < len; i++) {
                int cur = q.poll();

                for (int j = 0; j < 3; j++) {
                    int np = cur + dis[j];
                    if (np == e) {
                        return L + 1;
                    }
                    if (np >= 1 && np <= 10000 && ch[np] == 0) {
                        ch[np] = 1;
                        q.offer(np);
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
