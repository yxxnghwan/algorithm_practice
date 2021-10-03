package implementation;

import java.util.Scanner;

public class RoyalKnight {
    public static void main(String[] args) {
        /*
         행복 왕국의 왕실 정원은 체스판과 같은 8 × 8 좌표 평면입니다. 왕실 정원의 특정한 한 칸에 나이
            트가 서 있습니다. 나이트는 매우 충성스러운 신하로서 매일 무술을 연마합니다.

        • 나이트는 말을 타고 있기 때문에 이동을 할 때는 L자 형태로만 이동할 수 있으며 정원 밖으로는
            나갈 수 없습니다.

        • 나이트는 특정 위치에서 다음과 같은 2가지 경우로 이동할 수 있습니다.
        1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
        2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기

        이처럼 8 × 8 좌표 평면상에서 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수
        를 출력하는 프로그램을 작성하세요. 왕실의 정원에서 행 위치를 표현할 때는 1부터 8로 표현하
        며, 열 위치를 표현할 때는 a부터 h로 표현합니다.

        입력 조건 : 첫째 줄에 8 * 8 좌표 평면상에서 현재 나이트가 위치한 곳의 좌표를 나타내는 두 문자로 구성된 문자열이 입력된다.
                    입력 문자는 a1처럼 열과 행으로 이뤄진다.

        출력 조건 : 첫째 줄에 나이트가 이동할 수 있는 경우의 수를 출력하시오.

        입력예시
        a1

        출력예시
        2
         */

        int [] dx = {-1, 1, -1, 1, -2, -2, 2, 2};
        int [] dy = {-2, -2, 2, 2, -1, 1, -1, 1};

        Scanner sc = new Scanner(System.in);

        String knight = sc.next();
        int x = knight.charAt(0) - 96;
        int y = Integer.parseInt(knight.charAt(1)+"");

        int count = 0;

        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 1 || ny < 1 || nx > 8 || ny > 8) continue;

            count++;
        }

        System.out.println(count);

    }
}
