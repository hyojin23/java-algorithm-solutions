package BOJ.BOJ1339;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class AlphaObj implements Comparable<AlphaObj> {

    char ch;
    int cnt;

    AlphaObj(char ch, int cnt) {
        this.ch = ch;
        this.cnt = cnt;
    }
    @Override
    public int compareTo(AlphaObj ob) {
        return ob.cnt - this.cnt;
    }
}

public class Main {

    public int solution(int N, int M, char[][] charArr) {

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> countMap = new HashMap<>();
        List<AlphaObj> list = new ArrayList<>();
        int[][] numArr = new int[N][M];

        //백의 자리 > 100, 십의 자리 > 10, 일의 자리 > 1로 가중치를 부여하여 문자별 총 가중치 계산
        int weight = (int)Math.pow(10, M - 1);
        int num = 9;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                char c = charArr[j][i];
                if (c == '*') {
                    continue;
                }
                countMap.put(c, countMap.getOrDefault(c, 0) + weight);
            }
            weight /= 10;
        }

        //가중치가 큰 수부터 9, 8, 7 순으로 숫자 바인딩
        for (char key : countMap.keySet()) {
            list.add(new AlphaObj(key, countMap.get(key)));
        }
        Collections.sort(list);
        for (AlphaObj ob : list) {
            map.put(ob.ch, num);
            num--;
        }

        //단어 알파벳 배열을 숫자 배열로 변환
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map.containsKey(charArr[j][i])) {
                    numArr[j][i] = map.get(charArr[j][i]);
                }
            }
        }

        //각 단어의 숫자를 더해 전체 합 계산
        int answer = 0;
        for (int[] intArr : numArr) {
            answer += getIntFromArr(intArr);
        }

        return answer;
    }

    public int getIntFromArr(int[] arr) {

        int result = 0;
        for (int x : arr) {
            result = result * 10 + x;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            if (arr[i].length() > maxLength) {
                maxLength = arr[i].length();
            }
        }

        char[][] charArr = new char[N][maxLength];
        for (int i = 0; i < N; i++) {
            String result = String.format("%" + maxLength + "s", arr[i]).replace(' ', '*');
            for (int j = 0; j < maxLength; j++) {
                charArr[i][j] = result.charAt(j);
            }
        }
        System.out.println(T.solution(N, maxLength, charArr));
    }
}
