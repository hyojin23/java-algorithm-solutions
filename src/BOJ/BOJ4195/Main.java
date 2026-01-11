package BOJ.BOJ4195;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

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

    public static int union(int a, int b, int[] size) {

        int fa = find(a);
        int fb = find(b);

        if (fa == fb) {
            return fa;
        }

        parent[fa] = fb;
        size[fb] += size[fa];
        return fb;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int F = Integer.parseInt(br.readLine());
            parent = new int[F * 2 + 1];
            int[] size = new int[F * 2 + 1];
            Map<String, Integer> map = new HashMap<>();

            for (int z = 1; z <= F * 2; z++) {
                parent[z] = z;
                size[z] = 1;
            }

            int num = 1;
            for (int j = 0; j < F; j++) {
                String[] ids = br.readLine().split(" ");
                for (int k = 0; k < 2; k++) {
                    if (!map.containsKey(ids[k])) {
                        map.put(ids[k], num++);
                    }
                }
                int num1 = map.get(ids[0]);
                int num2 = map.get(ids[1]);

                //루트 노드가 같으면 한쪽 루트의 size를 출력, 루트 노드가 다르면 union 후 최종 루트 노드에 사이즈 기록 후 출력
                int root = union(num1, num2, size);
                System.out.println(size[root]);
            }
        }
    }
}
