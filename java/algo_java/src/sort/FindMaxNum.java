package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMaxNum {
    /*
    연결하여 만들 수 있는 가장 큰 수 찾기

    숫자가 주어지면, 이를 연결하여 만들 수 있는 가장 큰 수를 찾아라. 각각의 숫자는 연결하여 만들 수 있는 가장 큰 숫자를 만들기 위해 서로
    연결된다.
    Find largest number possible from set of given numbers. The numbers should be appended to each other in any order to from the largest number.
    (예) {2, 3, 4, 0, 6}의 숫자가 주어지면,
    연결하여 만들 수 있는 가장 큰 수는 64320

    입력 Input: {2, 3, 4, 0, 6}
    출력 Output: {2, 3, 4, 0, 6}의 숫자를 연결하여 만들 수 있는 가장 큰 수

    64320
    입출력 예

    입력
    Input: {10, 68, 75, 7, 21, 12 }

    출력
    Output: 77568211210
     */
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("10", "68", "75", "7", "21", "12");
        // sort using a custom function object
        Collections.sort(numbers, (a, b) -> (b + a).compareTo(a + b));
        // print the sorted sequence
        numbers.stream().forEach(System.out::print);
    }
}
