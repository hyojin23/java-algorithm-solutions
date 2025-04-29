package Recommended_Problems.DFS_BFS.BOJ9019;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Register {

    String c;
    int n;

    Register(String c, int n) {
        this.c = c;
        this.n = n;
    }
}

public class Main {

    char[] command = {'D', 'S', 'L', 'R'};
    int[] ch = new int[10000];

    public String BFS(int A, int goal) {

        Arrays.fill(ch, 0);
        Queue<Register> q = new LinkedList<>();
        ch[A] = 1;
        q.offer(new Register("", A));
        int nn = 0;
        while (!q.isEmpty()) {
            Register reg = q.poll();
            for (int j = 0; j < 4; j++) {
                if (command[j] == 'D') {
                    nn = reg.n * 2;
                    if (nn > 9999) {
                        nn = nn % 10000;
                    }
                }
                else if (command[j] == 'S') {
                    nn = reg.n - 1;
                    if (nn == -1) {
                        nn = 9999;
                    }
                }
                else if (command[j] == 'L') {
                    int a = reg.n % 1000;
                    int b = reg.n / 1000;
                    nn = a * 10 + b;
                }
                else if (command[j] == 'R') {
                    int a = reg.n % 10;
                    int b = reg.n / 10;
                    nn = a * 1000 + b;
                }
                if (ch[nn] == 0) {
                    StringBuilder sb = new StringBuilder(reg.c);
                    sb.append(command[j]);
                    if (nn == goal) {
                        return sb.toString();
                    }
                    ch[nn] = 1;
                    q.offer(new Register(sb.toString(), nn));
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println(T.BFS(A, B));
        }
    }
}
