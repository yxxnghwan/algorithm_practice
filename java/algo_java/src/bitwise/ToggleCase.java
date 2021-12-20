package bitwise;

public class ToggleCase {
    /*
    주어진 문자열에 대해 대문자는 소문자로, 소문자는 대문자로 변경하는 함수를 작성하시오.
    Given a string, write a function that returns toggle case of a string using the bitwise operators in place.
    In ASCII codes, character ‘A’ is integer 65 = (0100 0001)2, while character ‘a’ is integer 97 = (0110 0001)2.
    Similarly, character ‘D’ is integer 68 = (0100 0100)2, while character ‘d’ is integer 100 = (0110 0100)2.
    As we can see, only sixth least significant bit is different in ASCII code of ‘A’ and ‘a’. Similar behavior can be seen in ASCII code of ‘D’ and ‘d’.
    Therefore, we need to toggle this bit for toggling case.
    비트 연산을 통해 문자의 대소문자바꾸기
    Toggle case of a string using Bitwise Operators
    입력 Input: "GeekSfOrgEEKs"
    출력 Output: "gEEKsFoRGeekS"
    입출력 예
    입력
    Input: "StRinG"
    출력
    Output: "sTrINg"


    !!! 왼쪽 6번째 비트 값이 0이면 대문자, 1이면 소문자
        왼쪽 6번째 비트 값이 0이면 1로, 1이면 0으로 바꾼다.
        ==> 32와 XOR를 한 값
     */
    public static void main(String[] args) {
        System.out.println(toToggleCase("StriNg"));
    }

    public static String toToggleCase(String s) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            result.append((char)(s.charAt(i) ^ 32));
        }

        return result.toString();
    }
}
