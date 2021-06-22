package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 자르기
 */
public class boj2283 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] lines = new int[1000001];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j=x; j<y; j++) {
                lines[j] += 1;
            }
        }

        int sum = 0;
        int left = 0;
        for (int i=0; i<lines.length; i++) {

            if (sum < k) {
                sum += lines[i];
            } else if (sum > k) {
                while (sum > k && left < i) {
                    sum -= lines[left++];
                }
                i--;
            }

            if (sum == k){
                System.out.println(left + " " + (i+1));
                return;
            }
        }

        System.out.println("0 0");
    }

}
