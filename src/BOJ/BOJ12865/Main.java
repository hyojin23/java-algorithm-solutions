package BOJ.BOJ12865;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Item {

    int w, v;

    Item(int w, int v) {
        this.w = w;
        this.v = v;
    }
}

public class Main {

    public int solution(int N, int K, List<Item> list) {
        int[] bag = new int[K + 1];
        for (Item item : list) {
            for (int i = K; i >= item.w; i--) {
                bag[i] = Math.max(bag[i], bag[i - item.w] + item.v);
            }
        }
        return bag[K];
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int W = sc.nextInt();
            int V = sc.nextInt();
            list.add(new Item(W, V));
        }
        System.out.println(T.solution(N, K, list));
    }
}
