package BOJ.BOJ1043;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Main {

    static int[] parent;
    static List<Integer>[] parties;

    public static void Union(int a, int b) {

        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            parent[fb] = fa;
        }
    }

    public static int Find(int v) {
        if (parent[v] == v) {
            return v;
        }
        else {
            return parent[v] = Find(parent[v]);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int truthCnt = Integer.parseInt(st.nextToken());
        boolean[] truth = new boolean[N + 1];
        parties = new ArrayList[M];
        List<Integer> truthPeople = new ArrayList<>();
        for (int i = 0; i < truthCnt; i++) {
            int person = Integer.parseInt(st.nextToken());
            truth[person] = true;
            truthPeople.add(person);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyCnt = Integer.parseInt(st.nextToken());
            parties[i] = new ArrayList<>();
            int first = Integer.parseInt(st.nextToken());
            parties[i].add(first);
            for (int j = 1; j < partyCnt; j++) {
                int next = Integer.parseInt(st.nextToken());
                parties[i].add(next);
                Union(first, next);
            }
        }

        Set<Integer> truthRoots = new HashSet<>();
        for (int person : truthPeople) {
            truthRoots.add(Find(person));
        }
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int people : parties[i]) {
                if (truthRoots.contains(Find(people))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
