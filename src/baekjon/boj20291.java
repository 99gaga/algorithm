package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * 파일 정리
 * https://www.acmicpc.net/problem/20291
 */
public class boj20291 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> extMaps = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String ext = br.readLine().split("\\.")[1];
            extMaps.put(ext, extMaps.getOrDefault(ext, 0) + 1);
        }

        for (String ext : extMaps.keySet()) {
            System.out.println(ext + " " + extMaps.get(ext));
        }
    }
}
