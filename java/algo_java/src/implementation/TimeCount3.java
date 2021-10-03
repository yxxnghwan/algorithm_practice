package implementation;

import java.util.Scanner;

public class TimeCount3 {
    public static void main(String[] args) {
        /*
        • 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포
            함되는 모든 경우의 수를 구하는 프로그램을 작성하세요. 예를 들어 1을 입력했을 때 다음은 3이
            하나라도 포함되어 있으므로 세어야 하는 시각입니다.
        • 00시 00분 03초
        • 00시 13분 30초
        • 반면에 다음은 3이 하나도 포함되어 있지 않으므로 세면 안 되는 시각입니다.
        • 00시 02분 55초
        • 01시 27분 45초

        입력
        • 첫째 줄에 정수 N이 입력됩니다. (0 <= N <= 23)
        • 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 출력합니다.

        입력예시
        5

        출력예시
        11475
         */

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;

        for(int h = 0; h <= n; h++) {
            for(int m = 0; m <= 59; m++) {
                for(int s = 0; s <= 59; s++) {
                    String timeStr = h + "" + m + "" + s;
                    if(timeStr.contains("3")) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
