package dfs;

import java.util.*;

public class Maze {
    /*
    • 동빈이는 N × M 크기의 직사각형 형태의 미로에 갇혔습니다. 미로에는 여러 마리의 괴물이 있
    어 이를 피해 탈출해야 합니다.
    • 동빈이의 위치는 (1, 1)이며 미로의 출구는 (N, M)의 위치에 존재하며 한 번에 한 칸씩 이동할
    수 있습니다. 이때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있습니다. 미로
    는 반드시 탈출할 수 있는 형태로 제시됩니다.
    • 이때 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하세요. 칸을 셀 때는 시작 칸
    과 마지막 칸을 모두 포함해서 계산합니다

    입력조건
    첫째 줄에 두 정수 N,M(4<=N, M <= 200)이 주어집니다. 다음 N개의 줄에는 각각 M개의 정수 (0 혹은 1)로 미로의 정보가 주어집니다.
    각각의 수들은 공백 없이 붙어서 입력으로 제시됩니다. 또한 시작칸과 마지막칸은 항상 1입니다.

    출력조건
    첫째 줄에 최소 이동칸의 개수를 출력합니다.

    입력예시
    5 6
    101010
    111111
    000001
    111111
    111111

    6 6
    101010
    111111
    000101
    111111
    100000
    111111

    출력예시
    10

    17
     */

    public static int [] xArr = {-1, 1, 0, 0};
    public static int [] yArr = {0, 0, -1, 1};
    public static int n;
    public static int m;
    public static int[][] maze;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        sc.nextLine();// 버퍼 비움

        // 미로 생성
        maze = new int[n][m];
        for(int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for(int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        sc.close();
        System.out.println(dfs(0, 0));

    }

    public static int dfs(int x, int y) {
        Node node = new Node(x, y);
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            node = stack.pop();
            x = node.getX();
            y = node.getY();
            System.out.println("[" + x + "," + y + "] 보기");
            for(int i = 0; i < 4; i++) {
                int nextX = x + xArr[i];
                int nextY = y + yArr[i];
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    System.out.println("[" + nextX + "," + nextY + "] 막힘");
                    continue;
                } else {
                    if(maze[nextX][nextY] == 1 || (maze[nextX][nextY] > 1 && maze[nextX][nextY] > maze[x][y] + 1)) { // DFS는 한번 방문했던 곳이어도 뒤에 들르는 경로가 최단거리일 수도 있음
                        System.out.println("[" + nextX + "," + nextY + "] 통과");
                        maze[nextX][nextY] = maze[x][y] + 1;
                        stack.push(new Node(nextX, nextY));
                    }
                }
            }
        }

        return maze[n-1][m-1];
    }

    public static class Node {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
