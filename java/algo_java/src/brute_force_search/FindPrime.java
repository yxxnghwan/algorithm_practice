package brute_force_search;

public class FindPrime {
    public static boolean[] comb = new boolean[10000000];
    public static boolean[] taken = new boolean[7];
    public static String num;
    public static void main(String[] args) {
        /*
        한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

        각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
         */
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        int answer = 0;
        num = numbers;
        rec("", 0);
        for(int i = 2; i < comb.length; i++)
            if(comb[i] && isPrime(i)) answer++;

        return answer;
    }

    public static void rec(String str, int idx) {
        if(idx == num.length() + 1) return;

        if(!str.equals("")) {
            int num = Integer.parseInt(str);
            comb[num] = true;
        }

        for(int i = 0; i < num.length(); i++) {
            if(!taken[i]) {
                taken[i] = true;
                rec(str+num.charAt(i), idx+1);
                taken[i] = false;
            }
        }
    }

    public static boolean isPrime(int number) {
        for(int i = 2; i <= Math.sqrt(number); ++i) {
            if(number % i == 0) return false;
        }

        return true;
    }
}
