package programmers;

import java.util.*;

/**
 * 여행 경로
 */
public class TravelRoute {

    public static void main(String[] args) {

        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

        String[] result = solution(tickets);
        Arrays.stream(result).forEach(System.out::println);
    }

    static List<String> routeCase = new ArrayList<>();
    static String route = "";

    private static String[] solution(String[][] tickets) {
        boolean[] visit;

        for (int i=0; i<tickets.length; i++) {
            visit = new boolean[tickets.length];
            String from = tickets[i][0], to = tickets[i][1];

            if (from.equals("ICN")) {
                route = from + " ";
                visit[i] = true;
                dfs(tickets, to, 1, visit);
            }
        }

        Collections.sort(routeCase);
        String[] answer = routeCase.get(0).split(" ");

        return answer;
    }

    private static void dfs(String[][] tickets, String des, int cnt, boolean[] visit) {
        route += des + " ";

        if (cnt == tickets.length) {
            routeCase.add(route);
            return;
        }

        for (int i=0; i<tickets.length; i++) {
            String from = tickets[i][0], to = tickets[i][1];

            if (from.equals(des) && !visit[i]) {
                visit[i] = true;
                dfs(tickets, to, cnt + 1, visit);
                visit[i] = false;
                route = route.substring(0, route.length() - 4);
            }
        }
    }
}
