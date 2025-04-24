package Recommended_Problems.DFS_BFS.BOJ14889;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static int[][] S;
    static int N;
    static int[] combi;
    static char[] people;

    public void combi(int L, int s) {

        if (L == N / 2) {
            Arrays.fill(people, 'L');
            for (int x : combi) {
                System.out.print(x + " ");
                people[x] = 'S';
            }
            System.out.println(Arrays.toString(people));
            System.out.println();
            for (int i = 0; i < N; i++) {
                if (people[i] == 'S') {

                }
            }
        }
        else {
            for (int i = s; i < N; i++) {
                combi[L] = i;
                combi(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = new int[N][N];
        combi = new int[N / 2];
        people = new char[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }
        T.combi(0, 0);

    }
}
