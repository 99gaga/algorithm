package baekjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 부품 대여장
 */
public class boj21942 {

    static Map<String, String> map = new HashMap<>();
    static Map<String, Long> results = new TreeMap<>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String expire = st.nextToken();
        int f = Integer.parseInt(st.nextToken());

        int DAY = Integer.parseInt(expire.substring(0, 3));
        int HOUR = Integer.parseInt(expire.substring(4, 6));
        int MIN = Integer.parseInt(expire.substring(7));
        int expireMinTime = (((DAY * 24) + HOUR) * 60) + MIN;

        for (int i=0; i<n; i++) {
            String input = br.readLine();
            String[] in = input.split(" ");

            String key = in[2] + in[3];
            String date = in[0] + " " + in[1];
            if (map.containsKey(key)) {
                String start = map.remove(key);
                Date startDate = sdf.parse(start);
                Date endDate = sdf.parse(date);

                long diffMin = (endDate.getTime() - startDate.getTime()) / 60000;
                if (expireMinTime < diffMin) {
                    results.put(in[3], (results.getOrDefault(in[3], 0L) + (diffMin - expireMinTime) * f));
                }
            } else {
                map.put(key, date);
            }
        }

        if (results.size() == 0) {
            System.out.println(-1);
            return;
        }

        Set<String> keys = new TreeSet<>(results.keySet());
        for (String key : keys) {
            System.out.println(key + " " + results.get(key));
        }

    }

}
