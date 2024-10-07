package Section6_Sorting_and_Searching.Coordinate_Alignment;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Coordinates_3rd implements Comparable<Coordinates_3rd>{

    int x;
    int y;

    public Coordinates_3rd(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinates_3rd c) {
        if (this.x == c.x) {
            return this.y - c.y;
        }
        else {
            return this.x - c.x;
        }
    }
}

public class Main_3rd {

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Coordinates_3rd> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            list.add(new Coordinates_3rd(x, y));
        }

        Collections.sort(list);

        for (Coordinates_3rd c : list) {
            System.out.println(c.x + " " + c.y);
        }
    }
}
