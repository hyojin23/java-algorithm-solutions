package BOJ.BOJ9466;

import java.util.Scanner;

public class Main {

    static int[] student;
    static boolean[] visited, finished;
    static int count;


    public void DFS(int now) {

        visited[now] = true;
        int next = student[now];
        if (!visited[next]) {
            DFS(next);
        }
        else if (!finished[next]) {
            count++;
            for (int i = next; i != now; i = student[i]) {
                count++;
            }
        }
        finished[now] = true;
    }


    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            student = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            for (int j = 1; j <= n; j++) {
                student[j] = sc.nextInt();
            }
            count = 0;
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    main.DFS(j);
                }
            }
            System.out.println(n - count);
        }
    }
}
