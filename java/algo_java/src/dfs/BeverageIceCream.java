package dfs;

import java.util.Scanner;

public class BeverageIceCream {
    /*
    음료수 얼려먹기

    입력조건 : 첫 번째 줄에 얼음 틀의 세로 길이 N과 가로 길이 M이 주어집니다 (1 <= N, M <= 1000)
                두 번째 줄부터 N + 1번째 줄까지 얼음 틀의 형태가 주어집니다.
                이때 구멍이 뚫려있는 부분은 0, 그렇지 않은 부분은 1입니다.

    출력조건 : 한번에 만들 수 있는 아이스크림의 개수를 출력합니다.

    입력 예시
    4 5
    00011
    00111
    01110
    11011

    출력 예시
    3
     */
    public static int N, M;
    public static int [][] graph = new int[1000][1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 버퍼 비움
        System.out.println("+++++++++++++");
        System.out.println("n : " + N + " m : " + M);

        // 2차원 리스트의 맵 정보 입력 받기
        for(int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for(int j=0; j < M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        sc.close();

        // 현재 노드에 대해 음료수 채움
        int result = 0;

        // 2차원 리스트의 맵 정보 입력 받기
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // 현재 위치에서 DFS 수행
                if(dfs(i, j)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    // DFS로 특정 노드를 방문하고 상하좌우로 연결된 모든 노드들도 방문
    public static boolean dfs(int x, int y) {
        // 주어진 범위를 벗어나는 경우에는 종료
        if (x <= -1 || x >= N || y <= -1 || y >= M) return false;

        // 현재 노드를 아직 방문하지 않았다면
        if(graph[x][y] == 0) {
            // 해당 노드 방문 처리
            graph[x][y] = 1;
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }
}
