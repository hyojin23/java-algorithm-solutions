package BOJ.BOJ1377;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Value implements Comparable<Value> {

    int num, orgIdx;

    Value(int num, int orgIdx) {
        this.num = num;
        this.orgIdx = orgIdx;
    }

    @Override
    public int compareTo(Value ob) {
        return Integer.compare(this.num, ob.num);
    }
}

public class Main {

    public static int solution(int N, List<Value> list) {

        Collections.sort(list);

        int max = Integer.MIN_VALUE;
        for (int srtdIdx = 0; srtdIdx < N; srtdIdx++) {
            Value value = list.get(srtdIdx);
            max = Math.max(max, value.orgIdx - srtdIdx);
        }
        return max + 1;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Value> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(new Value(Integer.parseInt(br.readLine()), i));
        }
        System.out.println(solution(N, list));
    }
}
