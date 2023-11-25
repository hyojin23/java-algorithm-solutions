package Section10_Dynamic_Programming.Building_The_Tallest_Tower;

import java.util.*;


class Brick_1st implements Comparable<Brick_1st> {
    int b, h, w;

    public Brick_1st(int b, int h, int w) {
        this.b = b;
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Brick_1st ob) {
        return ob.b - this.b;
    }
}
public class Main_1st {

    static int[] dy;
    public int solution(List<Brick_1st> list, int n) {

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

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Brick_1st> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list.add(new Brick_1st(a, b, c));
        }
        System.out.println(T.solution(list, n));
    }
}
