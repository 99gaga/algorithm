package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 전화번호 목록
 * https://www.acmicpc.net/problem/5052
 */
public class boj5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // test case

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // number case in test
            String[] numbers = new String[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = br.readLine();
            }

            Arrays.sort(numbers);
            if (isConsistence(numbers)) {
                System.out.println("YES\n");
            } else {
                System.out.println("NO\n");
            }
        }
    }

    private static boolean isConsistence(String[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1].startsWith(numbers[i])) {
                return false;
            }
        }
        return true;
    }

}
