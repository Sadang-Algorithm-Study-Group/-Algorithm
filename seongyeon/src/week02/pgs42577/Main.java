package week02.pgs42577;

import java.util.Arrays;

/**
 * 문제: 전화번호 목록
 */

public class Main {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            String currentPhoneNumber = phone_book[i];
            String nextPhoneNumber = phone_book[i+1];
            if (nextPhoneNumber.startsWith(currentPhoneNumber)) return false;
        }
        return true;
    }
}
