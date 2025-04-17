package Week1.Practice;

import java.util.Arrays;

public class PhoneBook {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 1; i <= phone_book.length - 1; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = {"119", "023119", "234", "567"};
        System.out.println(solution(phone_book));
    }
}
