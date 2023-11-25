package Section9_Greedy_Algorithm.Wrestler;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Wrestler implements Comparable<Wrestler> {

    int h, w;

    public Wrestler(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Wrestler o) {
        return o.h - this.h;
    }
}

public class Main {

    static int n;
    public int solution(List<Wrestler> list) {

        int answer = 0;
        int max = Integer.MIN_VALUE;

        Collections.sort(list);

        for (Wrestler w : list) {
            if (w.w > max) {
                max = w.w;
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc  = new Scanner(System.in);

        n = sc.nextInt();
        List<Wrestler> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int h = sc.nextInt();
            int w = sc.nextInt();

            list.add(new Wrestler(h, w));
        }

        System.out.println(T.solution(list));
    }
}
