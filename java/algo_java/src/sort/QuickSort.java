package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        /*
        퀵 정렬
        가장 많이 사용되는 정렬 알고리즘.
        퀵 정렬은 기준을 설정한 다음 큰 수와 작은 수를 교환한 후 리스트를 반으로 나누는 방식으로 동작.
        이러한 교환을 위한 기준을 '피벗' 이라함. 퀵 정렬을 수행하기 전 피벗을 어떻게 설정할 것인지 미리 명시해야 함.

        피벗을 설정하고 리스트를 분할하는 방법에 따라 여러 가지 방식으로 퀵 정렬을 구분.

        가장 대표적인 분할 방식 => 호어(Hoare)분할 방식
        호어 분할 방식은 '리스트에서 첫 번째 데이터를 피벗으로 정한다' 는 규칙으로 피벗을 설정.

        피벗 설정 후엔 왼쪽부터 피벗보다 큰 데이터를 찾고 오른쪽에선 피벗보다 작은 데이터를 찾음.
        그 후 큰 데이터와 작은 데이터의 위치를 서로 교환. 반복하면 '피벗'에 대한 정렬이 수행됨.

        예시)
        5 7 9 0 3 1 6 2 4 8

        1. 리스트의 첫 번째 데이터 '5'를 피벗으로 정한다. 왼쪽부터 5보다 큰 데이터 7을 선택, 오른쪽부터는 5보다 작은 데이터 4를 선택, 두 데이터 교환
        5 4 9 0 3 4 6 2 7 8

        2. 피벗보다 큰 데이터와 작은 데이터를 각각 찾아서 다시 교환 9와 2
        5 4 2 0 3 1 6 9 7 8

        3. 피벗보다 큰 데이터와 작은 데이터를 각각 찾음. 이때 왼쪽에서부터 찾는 값과 오른쪽에서부터 찾는 값의 위치가 엇갈리면 (1과 6이 선택되고 위치가 엇갈림)
        작은 데이터와 피벗의 위치를 변경한다. 1과 5의 위치를 변경
        1 4 2 0 3 5 6 9 7 8

        4. 5를 기준으로 왼쪽에 있는 데이터는 모두 5보다 작고 오른쪽에 있는 데이터는 모두 5보다 크다. 양쪽의 데이터에 따로따로 다시 피벗분할을 수행한다.
        1 4 2 0 3             6 9 7 8
        5. 위의 과정을 쭉 반복
         */

        int [] arr = {-180, 18, 0, 5, 8, 9, -16, 48, 109, -52, 1};

        quickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int [] arr, int start, int end) {
        if(start >= end) return; // 원소가 1개인 경우 종료

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            // 피벗보다 큰 데이터를 찾을 때까지 반복
            while(left <= end && arr[left] <= arr[pivot]) left++;

            // 피벗보다 작은 데이터를 찾을 때까지 반복
            while (right > start && arr[right] >= arr[pivot]) right--;

            if(left > right) { // 서로 위치가 교차되면 피벗과 작은 수 교환
                int tmp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = tmp;
            } else {            // 교차되지 않으면 서로 교환
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
            }

            // 분할이후 왼쪽부분과 오른쪽 부분에서 각각 다시 피벗분할 수행
            quickSort(arr, start, right -1);
            quickSort(arr, right + 1, end);
        }
    }
}
