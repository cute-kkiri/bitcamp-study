#include <stdio.h>

#include "calc.h"

int main() {
  int r1 = plus(100, 200);
  int r2 = minus(100, 200);
  printf("100 + 200 = %d\n", r1);
  printf("100 - 200 = %d\n", r2);
  return 0;
}