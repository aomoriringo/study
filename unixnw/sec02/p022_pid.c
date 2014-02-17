#include <stdio.h>
#include <stdlib.h>

main()
{
  printf("pid = %d, ppid = %d\n", getpid(), getppid());
  exit(0);
}
