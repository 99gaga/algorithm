package baekjon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//잃어버린 괄호
public class boj1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        boolean isFirst = true;
        StringTokenizer sub = new StringTokenizer(br.readLine(), "-");

        while (sub.hasMoreTokens()) {
            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");

            int temp = 0;
            while (add.hasMoreTokens()) {
                temp += Integer.parseInt(add.nextToken());
            }

            if (isFirst) {
                result += temp;
                isFirst = false;
            } else {
                result -= temp;
            }
        }

        System.out.println(result);
    }
}
