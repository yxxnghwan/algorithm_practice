package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        /*
        선택 정렬
        가장 원시적인 방법.
        가장 작은 데이터를 선택해 맨 앞의 원소와 자리교체, 그 다음으로 작은 원소랑 두번째랑 자리교체 ... 반복

        시간복잡도
        n-1 만큼 가장 작은 수를 찾아서 맨 앞으로 보냄,
        또한 가장 작은 수를 찾기 위해 비교 연산이 필요, 매번 n + (n-1) + (n-2) ... + 1 번의 연산 필요

        O(n²)
         */
        int [] arr = {-180, 18, 0, 5, 8, 9, -16, 48, 109, -52, 1};

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int [] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }
}
