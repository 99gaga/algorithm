package baekjon;

import java.util.Scanner;

public class boj2748 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        long result = fibonacci(n);
        System.out.println(result);
    }

    private static long fibonacci(int n) {
        if (n==0) return 0;
        if (n==1) return 1;

        long[] store = new long[n+1];
        store[0] = 0;
        store[1] = 1;
        for (int i = 2; i <= n; i++) {
            store[i] = store[i-1] + store[i-2];
        }

        return store[n];
    }
}
