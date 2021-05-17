package baekjon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int[] nums = new int[n];
        int max = -1;
        for (int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            max = Math.max(nums[i], max);
        }

        int[] d = new int[max+1];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int i=4; i<=max; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }

        for (int num : nums) {
            System.out.println(d[num]);
        }
    }

}
