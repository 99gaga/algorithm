package baekjon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//저울
public class boj2437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //input
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] weight = new int[n];
        for (int i=0; i<n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight);
        int maxNum = 0;
        int answer = 1;

        for (int i=0; i<n; i++) {
            if (maxNum+1 < weight[i]) {
                maxNum += 1;
                break;
            }
            maxNum += weight[i];

            if (i == n-1){
                maxNum += 1;
            }
        }

        System.out.println(maxNum);
    }
}
