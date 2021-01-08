package thisis.greedy;

import java.util.Scanner;

public class MakeOne {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int cnt = 0;

        while (n != 1) {
            if (n % k == 0) {
                n /= k;
                cnt++;
            } else {
                int target = (n / k) * k;
                cnt += (n - target);
                n = target;
            }
        }

        System.out.println(cnt);
    }
}
