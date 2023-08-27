package Section9_Greedy_Algorithm.Wrestler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Wrestler implements Comparable<Wrestler>{

    int h, w;

    public Wrestler(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Wrestler w) {
        return w.h - this.h;
    }
}
public class Main {

    public int solution(List<Wrestler> wList) {

        int max = Integer.MIN_VALUE;
        int answer = 0;

        for (Wrestler w : wList) {
            if (w.w > max) {
                max = w.w;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Wrestler> wList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Wrestler w = new Wrestler(sc.nextInt(), sc.nextInt());
            wList.add(w);
        }
        Collections.sort(wList);
        System.out.println(T.solution(wList));
    }
}
