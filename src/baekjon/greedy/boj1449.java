package baekjon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//수리공 항승
public class boj1449 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);
        int[] leak = new int[n];
        for (int i=0; i<leak.length; i++) {
            leak[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(leak);

        int cnt = 1;
        int tapeLength = leak[0] + l;

        for (int i=1; i<leak.length; i++) {
            if (leak[i] >= tapeLength) {
                tapeLength = leak[i] + l;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
