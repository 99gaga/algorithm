package thisis.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BigNumberRule {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();
        int[] num = new int[n];

        for (int i=0; i<n; i++) {
            num[i] = scan.nextInt();
        }

        Arrays.sort(num);
        int firstMax = num[n-1];
        int secondMax = num[n-2];

        int cnt = (m / (k + 1)) * k + m % (k + 1);
        int result = 0;
        result = cnt*firstMax + (m-cnt)*secondMax;

        System.out.println(result);
    }
}
