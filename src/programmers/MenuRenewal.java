package programmers;

import java.util.*;

/**
 * 2021 KAKAO BLIND RECRUITMENT
 * 메뉴 리뉴얼
 */
public class MenuRenewal {

    static Map<String, Integer> map = new HashMap<>();
    static int maxCnt;

    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        String[] result = solution(orders, course);
        for (String menu : result) {
            System.out.println(menu);
        }
    }

    private static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        List<String> menuList = new ArrayList<>();

        for (int i : course) {
            map.clear();
            maxCnt = 0;

            for (String order : orders) {
                char[] menu = order.toCharArray();
                Arrays.sort(menu);

                if (i <= order.length()) {
                    combination(menu, order.length(), i, 0, "");
                }
            }

            for (String key : map.keySet()) {
                if (maxCnt == map.get(key) && map.get(key) >= 2) {
                    menuList.add(key);
                }
            }
        }

        Collections.sort(menuList);
        answer = menuList.toArray(new String[0]);

        return answer;
    }

    private static void combination(char[] arr, int n, int r, int start, String result) {
        if (r == 0) {
            map.put(result, map.getOrDefault(result, 0) + 1);

            int cnt = map.get(result);
            if (maxCnt < cnt) {
                maxCnt = cnt;
            }

            return;
        }

        for (int i = start; i < arr.length; i++) {
            combination(arr, n, r-1, i+1, result + arr[i]);
        }
    }

}
