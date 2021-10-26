#include <stdio.h>
#include <string.h>
#define MAX_LEN 1000

int n, m;
int graph[201][201];
// 이동할 네 가지 방향 정의 (상, 하, 좌, 우) 
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

typedef struct _node {
    int x;
    int y;
} Node;

Node queue[MAX_LEN];
int top = -1;
void push(Node node) {
    if(top < MAX_LEN) {
        top++;
        queue[top] = node;
    }
}

int empty() {
    if(top == -1) return 1;

    return 0;
}

Node front() {
    return queue[0];
}

void pop() {
    for(int i = 1; i <= top; i++) {
        queue[i-1] = queue[i];
    }
    Node emptyNode;
    emptyNode.x = -1;
    emptyNode.y = -1;
    queue[top] = emptyNode;
    top--;
}

int main(void) {
    scanf("%d %d", &n, &m);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%1d", &graph[i][j]);
        }
    }
    printf("%d\n", bfs(0, 0));
    return 0;
}

int bfs(int x, int y) {
    // 큐(Queue) 구현을 위해 queue 라이브러리 사용
    Node node;
    node.x = x;
    node.y = y;
    push(node);
    // 큐가 빌 때까지 반복하기
    while(!empty()) {
        int x = front().x;
        int y = front().y;
        pop();
        // 현재 위치에서 4가지 방향으로의 위치 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 미로 찾기 공간을 벗어난 경우 무시
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) 
                continue;

            // 벽인 경우 무시
            if (graph[nx][ny] == 0) continue;

            // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
            if (graph[nx][ny] == 1) {
                graph[nx][ny] = graph[x][y] + 1;
                Node next;
                next.x = nx;
                next.y = ny;
                push(next);
            } 
        } 
    }
    
    // 가장 오른쪽 아래까지의 최단 거리 반환
    return graph[n - 1][m - 1];
}

