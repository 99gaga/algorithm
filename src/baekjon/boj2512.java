package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 예산
 * https://www.acmicpc.net/problem/2512
 */
public class boj2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] province = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i=0; i<n; i++) {
            province[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, province[i]);
        }
        int limitBudget = Integer.parseInt(br.readLine());

        int left = 0, right = max;
        int mid = (left + right) / 2;
        while (left <= right) {
            int totalBudget = getTotalAmount(province, mid);
            if (totalBudget <= limitBudget) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        System.out.println(mid);
    }

    public static int getTotalAmount(int[] province, int limitAmount) {
        return Arrays.stream(province).map((x) -> Math.min(x, limitAmount)).sum();
    }
}
