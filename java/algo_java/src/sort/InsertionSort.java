package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        /*
        삽입 정렬
        선택정렬에 비해 효율적, 필요할 때만 위치를 바꾸므로 데이터가 거의 정렬되어 있을 경우 유리.
        정렬되어있는 데이터 리스트에서 들어갈 위치를 찾은 뒤에 그 위치에 삽입.

        시간 복잡도
        O(n²)
        데이터가 거의 정렬되어 있을 경우 O(n)
         */
        int [] arr = {-180, 18, 0, 5, 8, 9, -16, 48, 109, -52, 1};

        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int [] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j >= 1; j--) {
                if(arr[j] < arr[j - 1]) { // 들어갈 위치 찾으며 왼쪽으로 한칸씩 이동
                    int tmp = arr[j];
                    arr[j] = arr[j -1];
                    arr[j - 1] = tmp;
                } else {                    // 위치 찾으면 멈춤
                    break;
                }
            }
        }
    }
}
