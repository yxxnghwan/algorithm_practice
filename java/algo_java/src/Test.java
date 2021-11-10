import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        String [] strArr = {"A","MAN","DRINK","WATER11"};
        System.out.println(Arrays.toString(solution(strArr, false)));
    }


    public static String[] solution(String[] grid, boolean clockwise) {
        String[] answer = new String[grid.length];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = "";
        }

        if(clockwise) {
            for(int i = grid.length-1; i >= 0; i--) {
                int startPoint = grid.length-1-i;
                answer[startPoint] = answer[startPoint] + grid[i].charAt(0)+"";
                startPoint++;
                for(int j = 1; j < grid[i].length(); j += 2) {
                    answer[startPoint] = answer[startPoint] + reverse(grid[i].substring(j, j+2));
                    startPoint++;
                }
            }
        } else {
            for(int i = 0; i < grid.length; i ++) {
                int startPoint = grid.length -1;
                for(int j = 0; j < grid[i].length()-1; j += 2) {
                    answer[startPoint] = answer[startPoint] + reverse(grid[i].substring(j, j+2));
                    startPoint--;
                }

                answer[startPoint] = answer[startPoint] + grid[i].charAt(grid[i].length()-1);
            }
        }

        return answer;
    }

    public static String reverse(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }


}
