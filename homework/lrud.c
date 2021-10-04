#include <stdio.h>
#include <string.h>

int n;
char _plans[100];
int x = 1, y = 1;

int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};
char moveTypes[4] = {'L', 'R', 'U', 'D'};

int main(void) {
	scanf("%d", &n);
	getchar();
	fgets(_plans, sizeof(_plans), stdin);
	_plans[strlen(_plans)-1] = '\0';
	char * plans = strtok(_plans, " ");
	while(plans != NULL) {

		int nx = -1, ny = -1;
		for (int j = 0; j < 4; j++) {
			char move[2] = {moveTypes[j], '\0'};

			if (strcmp(plans, move) == 0) {
				nx = x + dx[j];
				ny = y + dy[j];
			}
		}

		if (nx < 1 || ny < 1 || nx > n || ny > n) {
			plans = strtok(NULL, " ");
			continue;
		}
			
		x = nx;
		y = ny;

		plans = strtok(NULL, " ");
	}
	
	printf("%d, %d\n", x, y);
	
	return 0;
}
