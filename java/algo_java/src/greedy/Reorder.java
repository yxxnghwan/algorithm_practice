package greedy;

import java.util.Arrays;

public class Reorder {
    public static void main(String[] args) {
        /*
        정수 배열에서 모든 0 값을 찾아 배열의 뒤쪽에 배치시킨다. 단, 배열 값의 상대적 순서는 유지해
        야 한다.
        알고리즘의 시간 복잡도는 O(n), 추가 공간은 O(1)로 작성하시오

        (예) { 2, 3, 4, 0, 6 }의 배열인 경우, { 2, 3, 4, 6, 0 }을 출력한다

        [기출 관련 인터뷰]
        - 2018 삼성 인턴쉽 인터뷰
        - 2018 삼성 rd Bangalore 인턴쉽 인터
         */

        int [] arr = {6, 0, 8, 2, 0, 0, 4, 0, 1};

        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }

        System.out.println(j);

        for(int i = j; i < arr.length; i++) {
            arr[i] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }
}
