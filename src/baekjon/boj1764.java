package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 듣보잡
 * https://www.acmicpc.net/problem/1764
 */
public class boj1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        Set<String> nameSet = new HashSet<>();
        for (int i=0; i<n; i++) {
            String name = br.readLine();
            nameSet.add(name);
        }

        List<String> nameList = new ArrayList<>();
        for (int i=0; i<m; i++) {
            String name = br.readLine();
            if (nameSet.contains(name)) {
                nameList.add(name);
            }
        }

        Collections.sort(nameList);
        System.out.println(nameList.size());
        nameList.forEach(System.out::println);

    }
}
