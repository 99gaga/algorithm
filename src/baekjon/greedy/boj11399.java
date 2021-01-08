package baekjon.greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

// ATM
public class boj11399 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] elapsedTime = new int[n];

        for (int i=0; i<n; i++) {
            elapsedTime[i] = scan.nextInt();
        }

        int sum = getMinWaitTime(n, elapsedTime);

        System.out.println(sum);
    }

    private static int getMinWaitTime(int n, int[] elapsedTime) {
        int sum = 0;

        Arrays.sort(elapsedTime);
        for (int i=0; i<n; i++) {
            sum += elapsedTime[i] * (n - i);
        }

        return sum;
    }
}
