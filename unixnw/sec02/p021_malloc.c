int debug = 1;
char *progname;

main(argc, argv)
int argc;
char *argv[];
{
  int i;
  char *ptr, *malloc();

  progname = argv[0];
  printf("argc = %d\n", argc);
  for (i=1 ; i<argc ; i++){
    ptr = malloc(strlen(argv[i]) + 1);
    strcpy(ptr, argv[i]);
    if (debug)
      printf("%s\n", ptr);
  }
}
