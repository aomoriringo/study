/*
 * Print the type of file for each of the command line arguments.
 */

#include <sys/types.h>
#include <sys/stat.h>

void err_sys(const char* x)
{
  perror(x);
  exit(1);
}

main(argc, argv)
int  argc;
char *argv[];
{
  int         i;
  struct stat statbuff;
  char        *ptr;

  for (i=1 ; i<argc ; i++){
    printf("%s: ", argv[i]);
    if (stat(argv[i], &statbuff) < 0)
      err_sys("fstat error");

    switch(statbuff.st_mode & S_IFMT){
    case S_IFDIR:  ptr = "directory";         break;
    case S_IFCHR:  ptr = "character special"; break;
    case S_IFBLK:  ptr = "block special";     break;
    case S_IFREG:  ptr = "regular";           break;
#ifdef S_IFLNK
    case S_IFLNK:  ptr = "symbolic link";     break;
#endif
#ifdef S_IFSOCK
    case S_IFSOCK: ptr = "socket";            break;
#endif
#ifdef S_IFIFO
    case S_IFIFO:  ptr = "fifo";              break;
#endif
    default:       ptr = "** unknown mode **"; break;
    }
    printf("%s\n", ptr);
  }
  exit(0);
}
