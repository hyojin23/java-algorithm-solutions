package Section9_Greedy_Algorithm.Wrestler;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Wrestler_2nd implements Comparable<Wrestler_2nd> {

    int h, w;

    public Wrestler_2nd(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Wrestler_2nd o) {
        return o.h - this.h;
    }
}

public class Main_2nd {

    static int n;
    public int solution(List<Wrestler_2nd> list) {

        int answer = 0;
        int max = Integer.MIN_VALUE;

        Collections.sort(list);

        for (Wrestler_2nd w : list) {
            if (w.w > max) {
                max = w.w;
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc  = new Scanner(System.in);

        n = sc.nextInt();
        List<Wrestler_2nd> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int h = sc.nextInt();
            int w = sc.nextInt();

            list.add(new Wrestler_2nd(h, w));
        }

        System.out.println(T.solution(list));
    }
}
