package baekjon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//단어 수학
public class boj1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            charMap(br.readLine(), map);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(((o1, o2) -> o2 - o1));

        int num = 9;
        int result = 0;
        for (int x : list) {
            result += x * num--;
        }

        System.out.println(result);
    }

    private static void charMap(String readLine, Map<Character, Integer> map) {
        char[] word = readLine.toCharArray();
        int length = readLine.length();

        for (int i=0; i<length; i++) {
            map.put(word[i],
                    map.getOrDefault(word[i], 0) + (int)Math.pow(10, length-i-1));
        }
    }
}