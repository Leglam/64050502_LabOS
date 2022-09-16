#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int csum, msum;
/*
 * Q2.5 First : Answer will be : sum = -msum (because mother is done first and not
 * waiting)
 * 	Second : Answer will be : sum = csum - msum (normal answer if we use join)
 * 	Third : Answer will be */
void *runner (void *param);

int main (int argc, char *argv[]) {
	int mupper, total;
        mupper = atoi(argv[1]);
	pthread_t tid;
	pthread_attr_t attr;
	pthread_attr_init(&attr);
	
	for (int j = 0; j < 10000000; j++) {
		pthread_create(&tid, &attr, runner, argv[1]);
		msum = 0;
		for (int i = 0; i <= mupper; i++) {
			msum += i;
		}

		//pthread_join(tid, NULL);
		total = csum - msum;

		printf("sum = %d\n", total);
	}
	return 0;
}

void *runner(void *param) {
	int upper = atoi(param);
	csum = upper * 2;

	pthread_exit(0);
}

