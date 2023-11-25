package Section10_Dynamic_Programming.Building_The_Tallest_Tower;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Brick implements Comparable<Brick> {

    int s, h, w;

    public Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Brick ob) {
        return this.s - ob.s;
    }
}

public class Main {

    public int solution(int n, List<Brick> list) {

        int[] dy = new int[n];

        dy[0] = list.get(0).h;
        int answer = list.get(0).h;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(i).w > list.get(j).w) {
                    dy[i] = Math.max(dy[i], dy[j] + list.get(i).h);
                }
            }

            if (dy[i] == 0) {
                dy[i] = list.get(i).h;
            }

            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Brick> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list.add(new Brick(a, b, c));
        }

        Collections.sort(list);

        System.out.println(T.solution(n, list));
    }
}
