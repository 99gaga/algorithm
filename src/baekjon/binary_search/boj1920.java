package baekjon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 수 찾기
 */
public class boj1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");

        int M = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");

        Set<String> set = Arrays.stream(A).collect(Collectors.toSet());

        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (set.contains(number)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
