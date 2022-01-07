package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 수강신청
 * https://www.acmicpc.net/problem/13414
 */
public class boj13414 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int limit = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String personNumber = br.readLine();
            if (set.contains(personNumber)) {
                set.remove(personNumber);
            }
            set.add(personNumber);
        }

        int cnt = Math.min(set.size(), limit);
        for (String s : set) {
            System.out.println(s);
            cnt--;
            if (cnt == 0) break;
        }
    }
}
