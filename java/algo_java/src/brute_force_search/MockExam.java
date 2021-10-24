package brute_force_search;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MockExam {
    /*
    수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

    1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

    제한 조건
    시험은 최대 10,000 문제로 구성되어있습니다.
    문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
    가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

    입출력 예
    answers                         return
    [1,2,3,4,5]                     [1]
    [1,3,2,4,2]                     [1,2,3]
     */
    public static void main(String[] args) {
        int [] answers = {1,2,3,4,5};
        System.out.println(Arrays.toString(solution(answers)));
    }

    public static int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int aScore = 0;
        int bScore = 0;
        int cScore = 0;

        for(int i = 0; i < answers.length; i++) {
            int answerIndex = i % 40;
            if(a[answerIndex] == answers[i]) {
                aScore++;
            }
            if(b[answerIndex] == answers[i]){
                bScore++;
            }
            if(c[answerIndex] == answers[i]){
                cScore++;
            }
        }
        int max = 0;
        if(aScore >= bScore) {
            max = aScore;
        } else {
            max = bScore;
        }

        if(cScore > max) {
            max = cScore;
        }

        boolean[] highScore = {false, false, false};
        int n = 0;
        if(max == aScore) {
            highScore[0] = true;
            n++;
        }
        if(max == bScore) {
            highScore[1] = true;
            n++;
        }
        if(max == cScore) {
            highScore[2] = true;
            n++;
        }

        int[] answer = new int[n];
        int top = 0;
        for(int i=0; i < 3; i++) {
            if(highScore[i]) {
                answer[top] = i+1;
                top++;
            }
        }


        return answer;
    }
}
