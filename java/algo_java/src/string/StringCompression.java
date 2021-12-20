package string;

public class StringCompression {
	/*
	문자열 압축 – 2020 카카오 공채 코딩 테스트 문제

	입력
	압축할 문자열 S가 매개변수로 주어질 때, 1개 이상 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 구하시오.
	단) 1<= s의 길이 <=1000
	s는 알파벳 소문자로만 이루어져 있습니다.
	문자열은 제일 앞부터 정해진 길이만큼 잘라야 합니다.
	출력 1개이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 출력하시오.
	입출력 예

	입력
	aabbaccc
	문자열 1개단위 분할
	2a2ba3c
	7

	ababcdcdababcdcd
	문자열8개단위분할
	2ababcdcd
	2ab2cd2ab2cd
	9

	abcabcdede
	문자열3개단위분할
	2abcdede
	abcabc2de
	8

	abcabcabcabcdededededede
	2개- abcabcabcabc6de
	3개- 4abcdededededede
	4개 - abcabcabcabc3dede
	6개 - 2abcabc2dedede
	14
	 */
	public static void main(String[] args) {
		System.out.println(solution("abcabcabcabcdededededede"));
	}

	public static int solution(String str) {
		int answer = Integer.MAX_VALUE;
		for(int i = 1; i <= str.length() / 2; i++) {
			StringBuilder formatString = new StringBuilder();
			int count = 0;
			String recentStr = "";
			for(int j = 0; j < str.length(); j += i) {
				int targetPoint = Math.min(j + i, str.length());
				String temp = str.substring(j, targetPoint);
				if(temp.equals(recentStr)) {
					count++;
				} else {
					formatString.append(count <= 1 ? "" : count).append(recentStr);
					count = 1;
					recentStr = temp;
				}
			}
			formatString.append(count <= 1 ? "" : count).append(recentStr);
			if(formatString.length() < answer)
				answer = formatString.length();
		}

		return answer;
	}
}
