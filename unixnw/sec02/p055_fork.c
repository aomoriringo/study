/*
 * The value returned by getppid() is the process ID of the parent process for the calling process. A process ID value of 1 indicates that there is no parent process associated with the calling process.
 */

main()
{
  int childpid;

  if ( (childpid = fork()) == -1) {
    perror("can't fork");
    exit(1);
  } else if (childpid == 0) {
    /* child process */
    printf("child: childpid = %d, parent pid = %d\n",
	   getpid(), getppid());
    exit(0);
  } else {
    /* parent process */
    sleep(1);
    printf("parent: child pid = %d, parent pid = %d\n",
	   childpid, getpid());
    exit(0);
  }
}
