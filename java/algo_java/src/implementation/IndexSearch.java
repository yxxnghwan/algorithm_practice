package implementation;

public class IndexSearch {

    /*
    배열이 주어지고, 배열의 모든 왼쪽 값은 자신의 값 보다 작고, 모든 오른쪽 값은 자신의 값 보다 큰 항목을 찾는다. 그런 조건에 맞는 항목을
    찾으면 그 항목의 색인 값을 반환하고, 그런 항목이 없으면 -1 값을 반환한다. 예상 시간 복잡도는O(n)
    Given an array, find an element before which all elements are smaller than it, and after which all are greater than it. Return the index of the
    element if there is such an element, otherwise, return –1. Expected time complexity: O(n).

    입력 Input: arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9}
    정수 배열
    출력 Output: 4
    All elements on left of arr[4] are smallerthan it and all elements on right are greater.
    입출력
    예
    입력
    Input: arr[] = {5, 1, 4, 4};
    출력
    Output: -1
    No such index exits.


    !!! 조건에 충족하는 원소가 여러 개일 경우 모든 원소 출력 !!!
     */
    public static void main(String[] args) {
        solution(new int[]{5, 1, 4, 3, 6, 8, 10, 7, 9});

        solution(new int[] {1, 2, 3, 4});
    }

    public static void solution(int [] arr) {
        boolean find = false;

        int [] leftMax = new int[arr.length];
        int [] rightMin = new int[arr.length];
        leftMax[0] = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);
        }

        rightMin[arr.length-1] = Integer.MAX_VALUE;

        for(int i = arr.length-2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i + 1]);
        }

        for(int i = 0; i < arr.length; i++) {
            if(leftMax[i] < arr[i] && rightMin[i] > arr[i]){
                System.out.println(i);
                find = true;
            }
        }

        if(!find) System.out.println(-1);
    }
}
