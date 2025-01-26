package Section10_Dynamic_Programming.Building_The_Tallest_Tower;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Brick_6th implements Comparable<Brick_6th> {

    int b, h, w;

    Brick_6th(int b, int h, int w) {
        this.b = b;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick_6th ob) {
        return ob.b - this.b;
    }
}

public class Main_6th {

    public int solution(int n, List<Brick_6th> list) {

        Collections.sort(list);
        int[] dy = new int[n];
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).w > list.get(i).w) {
                    max = Math.max(max, dy[j]);
                }
            }
            dy[i] = max + list.get(i).h;
            answer = Math.max(dy[i], answer);
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Brick_6th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int b = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();

            list.add(new Brick_6th(b, h, w));
        }
        System.out.println(T.solution(n, list));
    }
}
