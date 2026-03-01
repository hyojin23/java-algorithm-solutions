package BOJ.BOJ12865;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Item_1st {

    int w, v;

    Item_1st(int w, int v) {
        this.w = w;
        this.v = v;
    }
}

public class Main_1st {

    public int solution(int N, int K, List<Item_1st> list) {
        int[] bag = new int[K + 1];
        for (Item_1st item : list) {
            for (int i = K; i >= item.w; i--) {
                bag[i] = Math.max(bag[i], bag[i - item.w] + item.v);
            }
        }
        return bag[K];
    }


    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Item_1st> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int W = sc.nextInt();
            int V = sc.nextInt();
            list.add(new Item_1st(W, V));
        }
        System.out.println(T.solution(N, K, list));
    }
}
