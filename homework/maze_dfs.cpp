#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int n, m;
int graph[201][201];
// 이동할 네 가지 방향 정의 (상, 하, 좌, 우) 
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int main(void) {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%1d", &graph[i][j]);
        }
    }
    cout << dfs(0, 0) << '\n';
    return 0;
}

int dfs(int x, int y) {
    // 스택(Stack) 구현을 위해 stack 라이브러리 사용
    stack<pair<int, int> > st;
    st.push({x, y});
    // 스택이 빌 때까지 반복하기
    while(!st.empty()) {
        int x = st.top().first;
        int y = st.top().second;
        st.pop();
        // 현재 위치에서 4가지 방향으로의 위치 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 미로 찾기 공간을 벗어난 경우 무시
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

            // 벽인 경우 무시
            if (graph[nx][ny] == 0) continue;

            // DFS는 한번 방문했던 곳이어도 뒤에 들르는 경로가 최단거리일 수도 있음
            if (graph[nx][ny] == 1 || (graph[ny][nx] > 1 && graph[nx][ny] > graph[x][y] + 1)) {
                graph[nx][ny] = graph[x][y] + 1;
                st.push({nx, ny});
            } 
        } 
    }
    // 가장 오른쪽 아래까지의 최단 거리 반환
    return graph[n - 1][m - 1];
}