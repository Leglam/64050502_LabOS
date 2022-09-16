// Nopparuj Kanyasin 64050502
#include <stdio.h>
int main() {
     int a, b, ct;
     double average;
     a = 0;
     ct = 1;
     scanf("%d\n", &b);
     while (b > 0) {
          a += b;
          scanf("%d\n", &b);
	  if(b > 0) {
		  ct++;
	  }
     }
     average = (double) a/ct;
     printf("The sum of a is = %d, and The average is = %.2lf\n", a, average);
     return 0;
}
