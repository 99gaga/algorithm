package baekjon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 숫자 카드 2
 */
public class boj10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");

        int M = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String card : cards) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            sb.append(map.getOrDefault(number, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
