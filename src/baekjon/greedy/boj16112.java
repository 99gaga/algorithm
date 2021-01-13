package baekjon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//5차전직
public class boj16112 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String[] exprInput = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        long[] expr = new long[n];
        for (int i=0; i<n; i++) {
            expr[i] = Integer.parseInt(exprInput[i]);
        }

        Arrays.sort(expr);

        long exprSum = 0;
        for (int i=1; i<n; i++) {
            exprSum += (i < k) ? (expr[i] * i) : (expr[i] * k);
        }
        System.out.println(exprSum);
    }
}
