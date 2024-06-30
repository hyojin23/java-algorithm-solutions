package Section10_Dynamic_Programming.Building_The_Tallest_Tower;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Brick implements Comparable<Brick> {

    int a, h, w;

    Brick (int a, int h, int w) {
        this.a = a;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick ob) {
        return ob.a - this.a;
    }
}

public class Main {

    public int solution(int n, List<Brick> list) {

        int answer = 0;
        int[] dy = new int[n];

        Collections.sort(list);

        for (int i = 0; i < n; i++) {
            dy[i] = list.get(i).h;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                Brick my = list.get(i);
                Brick bf = list.get(j);

                if (bf.w > my.w) {
                    int max = dy[j] + my.h;
                    dy[i] = Math.max(max, dy[i]);
                }
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
            int h = sc.nextInt();
            int w = sc.nextInt();

            list.add(new Brick(a, h, w));
        }

        System.out.println(T.solution(n, list));
    }
}
