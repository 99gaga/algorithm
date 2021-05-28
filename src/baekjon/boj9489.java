package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 사촌
 */
public class boj9489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (n == 0 && k == 0) break;

            Map<Integer, Integer> relations = new HashMap<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(-1);
            st = new StringTokenizer(br.readLine());
            int preNum = -1, parent = -1;
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                q.offer(num);
                if (num > preNum + 1) {
                    parent = q.poll();
                }
                preNum = num;
                relations.put(num, parent);
            }

            int p1 = relations.get(k);
            if (p1 == -1) continue;
            int p2 = relations.get(p1);

            int cnt = 0;
            for (int x : relations.keySet()) {
                int pp1 = relations.get(x);
                if (pp1 == -1) continue;
                int pp2 = relations.get(pp1);
                if (pp2 == -1) continue;
                if (p1 != pp1 && p2 == pp2) cnt++;
            }

            System.out.println(cnt);
        }
    }
}
