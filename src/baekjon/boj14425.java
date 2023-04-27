package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/14425
public class boj14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<String> stringSet = new HashSet<>();
        while (n-- > 0) {
            stringSet.add(br.readLine());
        }
        int count = 0;
        while (m-- > 0) {
            String s = br.readLine();
            if (stringSet.contains(s)) {
                count++;
            }
        }

        System.out.println(count);
    }

}
