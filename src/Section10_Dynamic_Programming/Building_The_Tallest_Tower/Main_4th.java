package Section10_Dynamic_Programming.Building_The_Tallest_Tower;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Brick_4th implements Comparable<Brick_4th> {

    int a, h, w;

    Brick_4th(int a, int h, int w) {
        this.a = a;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick_4th ob) {
        return this.a - ob.a;
    }
}

public class Main_4th {

    static int n;
    public int solution(List<Brick_4th> list) {

        Collections.sort(list);
        int[] dy = new int[n];

        dy[0] = list.get(0).h;

        int answer = list.get(0).h;
        for (int i = 1; i < n; i++) {
            dy[i] = list.get(i).h;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).w < list.get(i).w) {
                    int nh = dy[j] + list.get(i).h;
                    dy[i] = Math.max(dy[i], nh);
                }
            }
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        List<Brick_4th> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();

            list.add(new Brick_4th(a, h, w));
        }

        System.out.println(T.solution(list));
    }
}
