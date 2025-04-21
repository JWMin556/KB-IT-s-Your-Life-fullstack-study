package Week1.Advanced;

public class StringCompression {
    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            // 자르는 단위를 반복하는 곳이다.
            // 반복 비교가 가능한 최대 단위는 문자열 길이의 절반까지해도 괜찮음

            StringBuilder compressed = new StringBuilder(); //압축 문자열을 누적시킬 StringBuilder변수
            String prev = s.substring(0, i); // 이전 문자열 블록을 저장할 변수
            int count = 1;

            for (int j = i; j < s.length(); j+=i) {
                int endIdx = Math.min(j + i, s.length());
                String current = s.substring(j, endIdx);
                // 문자열을 i 크기 단위로 하나씩 자르면서 prev와 비교
                if (prev.equals(current)) {
                    count++;
                } else {
                    // 지금까지의 prev를 압축 문자열에 추가
                    if (count > 1) { compressed.append(count); } //반복 횟수가 2 이상이면 숫자 추가
                    compressed.append(prev);
                    prev = current;
                    count = 1;
                }
            }

            // 마지막 비교 후 압축 문자열에 결과를 넣지 않았기 때문에, 남아 있는 마지막 prev 블록을 직접 처리
            if (count > 1) { compressed.append(count); }
            compressed.append(prev);

            answer = Math.min(answer, compressed.length());  //i마다 압축한 문자열의 길이를 계산해서, 그중 가장 짧은 길이를 계속 저장
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc")); // 7
        System.out.println(solution("ababcdcdababcdcd")); // 9
        System.out.println(solution("abcabcdede")); // 8
        System.out.println(solution("abcabcabcabcdededededede")); // 14
        System.out.println(solution("xababcdcdababcdcd")); // 17
    }
}
