package Section10_Dynamic_Programming.Building_The_Tallest_Tower;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Brick_7th implements Comparable<Brick_7th> {

    int a, h, w;

    Brick_7th(int a, int h, int w) {
        this.a = a;
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Brick_7th ob) {
        return ob.a - this.a;
    }
}

public class Main_7th {

    public int solution(int n, List<Brick_7th> list) {

        Collections.sort(list);
        int[] dy = new int[n];
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(i).w < list.get(j).w && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + list.get(i).h;
            answer = Math.max(dy[i], answer);
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Brick_7th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Brick_7th(a, h, w));
        }
        System.out.println(T.solution(n, list));
    }
}
