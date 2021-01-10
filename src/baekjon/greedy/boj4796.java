package baekjon.greedy;

import java.util.ArrayList;
import java.util.Scanner;

//캠핑
public class boj4796 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int l, p, v;
        int result;
        int i = 1;

        while(true) {
            l = scan.nextInt();
            p = scan.nextInt();
            v = scan.nextInt();

            if (l==0 && p==0 && v==0) break;

            result = (maxAvailable(l, p, v));
            System.out.println("Case " + i++ + ": " + result);
        }
    }

    private static int maxAvailable(int l, int p, int v) {
        return (v/p*l) + Math.min(l, v%p);
    }
}
