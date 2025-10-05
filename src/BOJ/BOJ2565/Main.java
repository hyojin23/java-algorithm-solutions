package BOJ.BOJ2565;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Wire implements Comparable<Wire> {

    int A, B;

    Wire(int A, int B) {
        this.A = A;
        this.B = B;
    }

    @Override
    public int compareTo(Wire ob) {
        return Integer.compare(this.A, ob.A);
    }
}

public class Main {

    public int solution(int N, List<Wire> list) {

        Collections.sort(list);
        int[] LIS = new int[N];
        int maxNormalWires = 0;
        for (int i = 0; i < N; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (list.get(j).B < list.get(i).B) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
            maxNormalWires = Math.max(maxNormalWires, LIS[i]);
        }
        return N - maxNormalWires;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Wire> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            list.add(new Wire(A, B));
        }
        System.out.println(T.solution(N, list));
    }
}
