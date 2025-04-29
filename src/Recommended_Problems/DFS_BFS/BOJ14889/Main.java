package Recommended_Problems.DFS_BFS.BOJ14889;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static int[][] S;
    static int N, answer = Integer.MAX_VALUE;
    static int[] combi;
    static char[] people;

    public void combi(int L, int s) {

        if (L == N / 2) {
            int sScore = 0;
            int lScore = 0;

            Arrays.fill(people, 'L');
            for (int x : combi) {
                people[x] = 'S';
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (people[i] == 'S' && people[j] == 'S') {
                        sScore += S[i][j];
                    }
                    if (people[i] == 'L' && people[j] == 'L') {
                        lScore += S[i][j];
                    }

                }
            }
            answer = Math.min(answer, Math.abs(sScore - lScore));
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
        System.out.println(answer);
    }
}
