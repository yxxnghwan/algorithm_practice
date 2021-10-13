#include <stdio.h>
#include <string.h>

int visited[9];
int graph[9][3] = {{}, {2,3,8}, {1,7}, {1,4,5}, {3,5}, {3,4}, {7}, {2,6,8}, {1,7}};

void dfs(int x) {
    visited[x] = 1;
    printf("%d ", x);
    int nodeLength = sizeof(graph[x]) / sizeof(int);
    for (int i = 0; i < nodeLength; i++) {
        int node = graph[x][i];
        // 인접한 노드가 방문한 적이 없다면 DFS 수행
        if(node == 0) continue;
        
        if(!visited[node]) {    
            dfs(node);
        }
    }
}

int main(void) {
    dfs(1);
    return 0;
}