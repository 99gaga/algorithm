package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문자열
 * https://www.acmicpc.net/problem/1120
 */
public class boj1120 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String X = st.nextToken();
        String Y = st.nextToken();

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= Y.length() - X.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < X.length(); j++) {
                if (X.charAt(j) != Y.charAt(i + j)) {
                    cnt++;
                }
            }
            result = Math.min(result, cnt);
        }

        System.out.println(result);
    }
}
