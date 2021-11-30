package bitwise;

import java.util.Arrays;

public class KakaoSecretMap {
	/*
	비밀지도 – 2018 카카오 공채 코딩 테스트 문제

	- 지도는 한 변의 길이가 n인 정사각형 배열이며, 각 칸은 공백(“ “) 또는 벽(“#”)의 두 종류로 이루어져 있음
	- 전체 지도는 이런 두 장의 지도를 겹쳐서 얻을 수 있음
	- 두 장의 지도를 겹쳐서 얻은 전체 지도에서 어느 하나의 지도라도 벽인 경우는 전체 지도에서 벽이고,두 장 지도 모두 공백인 경우 전체 지도에서 공백임
	- 각각의 지도 “지도 1”과 “지도 2”는 각각 정수 배열로 암호화되어 있다.
	- 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다

	입력
	입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.
	- 1 ≦ n ≦ 16
	- arr1, arr2는 길이 n인 정수 배열로 주어진다.
	- 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2^n – 1을 만족한다.
	출력 원래의 비밀지도를 해독하여 "#", 공백으로 구성된 문자열 배열로 출력하라.
	입출력 예
	입력
	5
	[9, 20, 28, 18, 11]
	[30, 1, 21, 17, 28]
	출력
	["#####","# # #", "### #", "#  ##", "#####"]
	입력
	6
	[46, 33, 33 ,22, 31, 50]
	[27 ,56, 19, 14, 14, 10]
	출력
	["######", "###  #", "##  ##", " #### ", " #####", "### # "]
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
		System.out.println(Arrays.toString(solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10})));
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		int row;

		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			row = arr1[i] | arr2[i];
			String temp = "";
			for (int j = n-1; j >= 0; j--) {
				if ( ((row >> j) & 1) == 1)
					temp += "#";
				else
					temp += " ";
			}
			answer[i] = temp;
		}
		return answer;
	}
}
