package baekjon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//주식
public class boj11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n;

        for (int test=0; test<t; test++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] stock = new int[n];
            for (int i=0; i<n; i++) {
                stock[i] = Integer.parseInt(st.nextToken());
            }

            long result = getMaxBenefit(n, stock);
            System.out.println(result);
        }
    }

    private static long getMaxBenefit(int n, int[] stock) {
        int maxPrice = 0;
        long maxBenefit = 0;

        for (int i=n-1; i>=0; i--) {
            if (maxPrice < stock[i]) {
                maxPrice = stock[i];
            } else {
                maxBenefit += maxPrice - stock[i];
            }
        }
        return maxBenefit;
    }
}
