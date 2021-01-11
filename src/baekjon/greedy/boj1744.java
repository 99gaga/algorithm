package baekjon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//수 묶기
public class boj1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        for (int i=0; i<n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        int sum = 0;
        //양수
        for (int i=n-1; i>=0; i--) {
            if (i==0 && num[i] > 1) {
                sum += num[i];
            } else if (num[i] > 1 && num[i-1] > 1) {
                sum += (num[i] * num[i-1]);
                i--;
            } else if (num[i] >= 1) {
                sum += num[i];
            } else {
                 break;
            }
        }

        //음수,0
        for (int i=0; i<n; i++) {
            if (i==n-1 && num[i] <= 0) {
                sum += num[i];
            } else if (num[i] <= 0 && num[i+1] <= 0) {
                sum += (num[i] * num[i+1]);
                i++;
            } else if (num[i] <= 0) {
                sum += num[i];
            } else {
                break;
            }
        }

        System.out.println(sum);
    }
}
