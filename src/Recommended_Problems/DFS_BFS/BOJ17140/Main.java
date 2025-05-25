package Recommended_Problems.DFS_BFS.BOJ17140;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Number implements Comparable<Number> {

    int num, cnt;

    Number(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Number ob) {
        if (this.cnt == ob.cnt) {
            return this.num - ob.num;
        }
        else {
            return this.cnt - ob.cnt;
        }
    }
}

public class Main {

    public int solution(int r, int c, int k, int[][] A) {

        int time = 0;
        while (true) {
            if (time > 100) {
                return -1;
            }
            int rCnt = A.length;
            int cCnt = A[0].length;
            if (rCnt >= r && cCnt >= c && A[r - 1][c - 1] == k) {
                return time;
            }

            if (rCnt >= cCnt) {
                int max = Integer.MIN_VALUE;
                List<List<Number>> list = new ArrayList<>();

                for (int i = 0; i < rCnt; i++) {
                    list.add(new ArrayList<>());
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int j = 0; j < cCnt; j++) {
                        int key = A[i][j];
                        if (key == 0) {
                            continue;
                        }
                        map.put(key, map.getOrDefault(key, 0) + 1);
                    }
                    for (int v : map.keySet()) {
                        list.get(i).add(new Number(v, map.get(v)));
                    }
                    if (map.size() > max) {
                        max = map.size();
                    }
                    Collections.sort(list.get(i));
                }
                A = new int[rCnt][max * 2];

                for (int i = 0; i < rCnt; i++) {
                    int len = Math.min(list.get(i).size(), 50);
                    for (int j = 0; j < len; j++) {
                        A[i][j * 2] = list.get(i).get(j).num;
                        A[i][j * 2 + 1] = list.get(i).get(j).cnt;
                    }
                }
            }
            else {
                int max = Integer.MIN_VALUE;
                List<List<Number>> list = new ArrayList<>();

                for (int i = 0; i < cCnt; i++) {
                    list.add(new ArrayList<>());
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int j = 0; j < rCnt; j++) {
                        int key = A[j][i];
                        if (key == 0) {
                            continue;
                        }
                        map.put(key, map.getOrDefault(key, 0) + 1);
                    }
                    for (int v : map.keySet()) {
                        list.get(i).add(new Number(v, map.get(v)));
                    }
                    if (map.size() > max) {
                        max = map.size();
                    }
                    Collections.sort(list.get(i));
                }
                A = new int[max * 2][cCnt];
                for (int i = 0; i < cCnt; i++) {
                    int len = Math.min(list.get(i).size(), 50);
                    for (int j = 0; j < len; j++) {
                        A[j * 2][i] = list.get(i).get(j).num;
                        A[j * 2 + 1][i] = list.get(i).get(j).cnt;
                    }
                }
            }
            time++;
        }
    }


    public static void main(String[] argss) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();
        int[][] A = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(r, c, k, A));
    }
}
