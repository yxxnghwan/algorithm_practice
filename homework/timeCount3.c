#include <stdio.h>
#include <string.h>

int h, cnt;

// 특정한 시각 안에 '3'이 포함되어 있는지의 여부
int check(int h, int m, int s) {
    if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
        return 1;
    return 0;
}
int main(void) {
    // H 입력 받기
    scanf("%d", &h);
    for (int i = 0; i <= h; i++) {
        for (int j = 0; j < 60; j++) {
            for (int k = 0; k < 60; k++) {
                if (check(i, j, k)) cnt++;
            }
        }
    }
    printf("%d\n", cnt);
    return 0;
}
