#include <stdio.h>
#include <stdlib.h>

main(argc, argv)
int argc;
char *argv[];
{
  int         i;
  extern char **environ;

  for (i=0; environ[i] != (char *)0 ; i++)
    printf("%s\n", environ[i]);
  exit(0);
}
