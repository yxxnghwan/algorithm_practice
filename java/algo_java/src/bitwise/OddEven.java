package bitwise;


import java.util.Scanner;

public class OddEven {
    /*
    정수 값 N이 주어지면, bitwise연산을 이용하여 홀수인지 짝수 인지 검사하시오.
    Given a number N, the task is to check whether the number is even or odd using Bitwise Operators
    입력 Input: N = 11
    출력 Output: Odd
    입출력 예
    입력
    Input: N = 10
    출력
    Output: Even

    !!!
    N을 1과 XOR한 값이, 홀수이면 1만큼 감소하고 짝수이면 1만큼 증가
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(isEven(n)) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

    }

    public static boolean isEven(int n) {
        if((n ^ 1) == (n+1)) return true;
        else return false;
    }
}
