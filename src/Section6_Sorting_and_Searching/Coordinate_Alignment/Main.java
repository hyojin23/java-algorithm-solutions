package Section6_Sorting_and_Searching.Coordinate_Alignment;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Coordinates implements Comparable<Coordinates>{

    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinates c) {
        if (this.x == c.x) {
            return this.y - c.y;
        }
        else {
            return this.x - c.x;
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Coordinates> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            list.add(new Coordinates(x, y));
        }

        Collections.sort(list);

        for (Coordinates c : list) {
            System.out.println(c.x + " " + c.y);
        }
    }
}
