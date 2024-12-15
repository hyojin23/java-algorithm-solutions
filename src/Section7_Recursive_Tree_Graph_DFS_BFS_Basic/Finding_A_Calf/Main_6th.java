package Section7_Recursive_Tree_Graph_DFS_BFS_Basic.Finding_A_Calf;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main_6th {

    public int solution(int s, int e) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int L = 0;
        int[] ch = new int[10001];
        int[] jump = {1, -1, 5};
        ch[s] = 1;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int pos = q.poll();
                for (int j : jump) {
                    int np = pos + j;
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

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();

        System.out.println(T.solution(s, e));
    }
}
