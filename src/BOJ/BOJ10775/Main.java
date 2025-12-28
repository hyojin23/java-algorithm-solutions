package BOJ.BOJ10775;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static int[] parent;

    public static int find(int v) {

        if (parent[v] == v) {
            return v;
        }
        else {
            return parent[v] = find(parent[v]);
        }
    }

    public static void union(int a, int b) {

        int fa = find(a);
        int fb = find(b);

        if (fa != fb) {
            parent[fa] = fb;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];

        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        for (int i = 0; i < P; i++) {
            int p = Integer.parseInt(br.readLine());
            int available = find(p);

            if (available == 0) {
                break;
            }
            else {
                cnt++;
                union(available, available - 1);
            }
        }
        System.out.println(cnt);
    }
}
