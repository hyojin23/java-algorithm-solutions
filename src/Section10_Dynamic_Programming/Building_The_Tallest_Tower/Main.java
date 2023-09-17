package Section10_Dynamic_Programming.Building_The_Tallest_Tower;

import java.util.*;


class Brick implements Comparable<Brick> {
    int b, h, w;

    public Brick(int b, int h, int w) {
        this.b = b;
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Brick ob) {
        return ob.b - this.b;
    }
}
public class Main {

    static int[] dy;
    public int solution(List<Brick> list, int n) {

        int answer = 0;
        Collections.sort(list);
        dy = new int[n];

        dy[0] = list.get(0).h;
        answer = dy[0];

        for (int i = 0; i < n; i++) {
            int max_h = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).w > list.get(i).w && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }
            dy[i] = max_h + list.get(i).h;
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
            int b = sc.nextInt();
            int c = sc.nextInt();

            list.add(new Brick(a, b, c));
        }
        System.out.println(T.solution(list, n));
    }
}
