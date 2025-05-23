package Week5.Practice;

import java.util.*;

public class ReceiveReport {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        answer = new int[id_list.length];
        Map<String, List<String>> mapOfUser = new HashMap<>(); // <신고자, 신고당한놈들의 리스트>
        Map<String, Boolean> mapOfReport = new HashMap<>();  // 각 인원별로 신고를 당했는지

        // 먼저 각 인원별로 신고를 안당했다고 초기화
        for (String id : id_list) {
            mapOfReport.put(id, false);
        }

        // 이 부분을 자바코드로 짤줄 몰라서 조사했음
        for (String reportOne : report) {
            String[] splitReportOne = reportOne.split(" "); // [0]: 신고자 [1]: 신고당한놈
            if (!mapOfUser.containsKey(splitReportOne[0])) {
                mapOfUser.put(splitReportOne[0], new ArrayList<>());
            }
            List<String> userList = mapOfUser.get(splitReportOne[0]);
            if (!userList.contains(splitReportOne[1])) {
                userList.add(splitReportOne[1]);
            }
        }

        // 각 사람별로 신고당한 횟수를 세기위한 맵
        Map<String, Integer> reportedCount  = new HashMap<>();
        for (Collection<String> reportedUsers : mapOfUser.values()) {
            for (String user : reportedUsers) {
                reportedCount.put(user, reportedCount.getOrDefault(user, 0) + 1);
            }
        }

        // reportedCount에서 k번 이상 신고당한 사람의  mapOfReport를 true
        for (Map.Entry<String, Integer> entry : reportedCount.entrySet()) {
            if (entry.getValue() >= k) {
                mapOfReport.put(entry.getKey(), true);
            }
        }

        // mapOfUser의 각 신고자별로 자신들의 신고리스트에 있는 인원들에게 mapOfReport로 신고여부를 확인해서 그 개수만큼을 적는다.
        Map<String, Integer> userMailCount = new HashMap<>();  // 각 유저별로 신고를 성공했을 때, 몇개나 성공했는지
        for (String user : mapOfUser.keySet()) {
            List<String> whoReportedPeople = mapOfUser.get(user);
            int count = 0;
            for (String reportedHuman : whoReportedPeople) {
                if (mapOfReport.get(reportedHuman)) {
                    count++;
                    userMailCount.put(user, count);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            if (userMailCount.containsKey(id_list[i])) {
                answer[i] = userMailCount.get(id_list[i]);
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = new String[] {"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
//        String[] id_list = new String[] {"con", "ryan"};
//        String[] report = new String[] {"ryan con", "ryan con", "ryan con", "ryan con"};
//        int k = 3;
        int[] answer = solution(id_list, report, k);
        System.out.println(Arrays.toString(answer));
    }
}
