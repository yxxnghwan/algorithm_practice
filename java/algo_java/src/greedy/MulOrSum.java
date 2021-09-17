package greedy;

import java.util.Scanner;

public class MulOrSum {
    public static void main(String[] args) {
        /*
        • 각 자리가 숫자(0부터 9)로만 이루어진 문자열 S가 주어졌을 때, 왼쪽부터 오른쪽으로 하나씩
        모든 숫자를 확인하며 숫자 사이에 ‘×’ 혹은 ‘+’ 연산자를 넣어 결과적으로 만들어질 수 있는
        가장 큰 수를 구하는 프로그램을 작성하세요. 단, +보다 ×를 먼저 계산하는 일반적인 방식과
        는 달리, 모든 연산은 왼쪽에서부터 순서대로 이루어진다고 가정합니다.
        • 예를 들어 02984라는 문자열로 만들 수 있는 가장 큰 수는 ((((0 + 2) × 9) × 8) × 4) = 576입니다.
        또한 만들어질 수 있는 가장 큰 수는 항상 20억 이하의 정수가 되도록 입력이 주어집니다.
         */

        Scanner sc = new Scanner(System.in);

        String numStr = sc.next();
        int result = numStr.charAt(0)-'0';
        for(int i = 1; i < numStr.length(); ++i) {
            int nextNum = numStr.charAt(i)-'0';
            if(isOneOrZero(result) || isOneOrZero(nextNum)) {
                result += nextNum;
            } else {
                result *= nextNum;
            }
        }

        System.out.println(result);
    }

    static boolean isOneOrZero(int number) {
        return number == 1 || number == 0;
    }
}
