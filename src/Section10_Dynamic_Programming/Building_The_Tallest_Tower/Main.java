package Section10_Dynamic_Programming.Building_The_Tallest_Tower;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Brick implements Comparable<Brick> {

    int a, h, w;

    Brick(int a, int h, int w) {
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
