package bitwise;

import java.util.Scanner;

public class RightmostUnsetBit {
    /*
    양의 정수에 대해 가장 오른쪽 0 값의 비트를 1로 바꾼다. 만약 그런 0 값이 없으면 원래 정수를 반환한다.
    Given a non-negative number n. The problem is to set the rightmost unset bit in the binary representation of n. If there
    are no unset bits, then just leave the number as it is.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println((n+1) & ~n);
    }
}
