#include <stdio.h>
#include <stdlib.h>

main()
{
  char *ptr, *getenv();

  if ( (ptr = getenv("HOME")) == (char *) 0)
    printf("HOME is not defined\n");
  else
    printf("HOME=%s\n", ptr);
  exit(0);
}

