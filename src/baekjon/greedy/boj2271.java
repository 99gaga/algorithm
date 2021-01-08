package baekjon.greedy;

import java.util.Arrays;
import java.util.Scanner;

//로프
public class boj2271 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] ropes = new int[n];
        for (int i=0; i<n; i++) {
            ropes[i] = scan.nextInt();
        }

        Arrays.sort(ropes);
        int max = 0;
        for (int i=0; i<n; i++) {
            max = Math.max(ropes[i] * (n-i), max);
        }

        System.out.println(max);
    }
}
