#include <stdio.h>
#include <stdlib.h>
// #include <varargs.h>
#include <stdarg.h>
#include <error.h>
#include <errno.h>
#include "systype.h"

#ifdef CLIENT
#ifdef SERVER
cant define both CLIENT and SERVER
#endif
#endif

#ifndef CLIENT
#ifndef SERVER
#define CLIENT 1                /* default to client */
#endif
#endif

#ifndef NULL
#define NULL   ((void *) 0)
#endif

char *pname = NULL;

#ifdef CLIENT                   /* these all output to stderr */

/*
 * Fatal error related to a system call.  Print a message and terminate.
 * Don't dump core, but do print the system's errno value and its
 * associated message.
 *
 *      err_sys(str, arg1, arg2, ...)
 *
 * The string "str" must specify the conversion specification for any args.
 */

/*VARARGS1*/

/*
 * Original Code
 *
err_sys(va_alist)
va_dcl
{
  va_list args;
  char    *fmt;

  va_start(args);
  if (pname != NULL)
    fprintf(stderr, "%s: ", pname);
  fmt = va_arg(args, char *);
  va_end(args);

  my_perror();

  exit(1);
}
 */

err_sys(char *fmt, ...)
{
  va_list args;

  va_start(args, fmt);
  if (pname != NULL)
    fprintf(stderr, "%s: ", pname);
  fmt = va_arg(args, char *);
  va_end(args);

  my_perror();

  exit(1);
}

/*
 * Print the UNIX errno value.
 */

my_perror()
{
  char *sys_err_str();

  fprintf(stderr, " %s\n", sys_err_str());
}

#endif /* CLIENT */

#ifdef SERVER
/*
 * Fatal error related to a system call.  Print a message and terminate.
 * Don't dump core, but do print the system's errno value and its
 * associated message.
 *
 *      err_sys(str, arg1, arg2, ...)
 *
 * The string "str" must specify the conversion specification for any args.
 */

/* VARARGS1 */

/*
 * Original Code
 *
err_sys(va_alist)
va_dcl
{
  va_list args;
  char    *fmt;

  va_start(args);
  fmt = va_arg(args, char *);
  vsprintf(emesgstr, fmt, args);
  va_end(args);

  my_perror();
  syslog(LOG_ERR, emesgstr);

  exit(1);
}
 */

err_sys(char *fmt, ...)
{
  va_list args;

  va_start(args, fmt);
  fmt = va_arg(args, char *);
  vsprintf(emesgstr, fmt, args);
  va_end(args);

  my_perror();
  syslog(LOG_ERR, emesgstr);

  exit(1);
}

/*
 * Print the UNIX errno value.
 * We just append it to the end of the emesgstr[] array.
 */

my_perror()
{
  register int len;
  char         *sys_err_str();

  len = strlen(emesgstr);
  sprintf(emesgstr + len, " %s", sys_err_str());
}

#endif /* SERVER */

                            /* reminder is for both CLIENT and SERVER */
//extern int  errno;          /* Unix error number */
extern int  sys_nerr;       /* # of error message strings in sys table */
//extern char *sys_errlist[]; /* the system error message table */
extern __const char *__const sys_errlist[];

#ifdef SYS5
int  t_errno;           /* in case caller is using TLI, these are "tentative
			   definitions"; else they're "definitions" */
int  t_nerr;
char *t_errlist[1];
#endif

/*
 * Return a string containing some additional operating-system
 * dependent information.
 * Note that different versions of UNIX assign different meanings
 * to the same value of "errno" (compare errno's starting with 35
 * between System V and BSD, for example).  This means that if an error
 * condition is being sent to another UNIX system,. we must interpret
 * the errno value on the system that generated the error, and not
 * just send the decimal value of errno to the other system.
 */

char *
sys_err_str()
{
  static char msgstr[200];

  if (errno != 0) {
    if (errno > 0 && errno < sys_nerr)
      sprintf(msgstr, "(%s)", sys_errlist[errno]);
  } else {
    msgstr[0] = '\0';
  }

#ifdef SYS5
  if (t_errno != 0) {
    char tmsgstr[100];

    if (t_errno > 0 && t_errno < sys_nerr)
      sprintf(tmsgstr, " (%s)", t_errlist[t_errno]);
    else
      sprintf(tmsgstr, ", (t_errno = %d)", t_errno);

    strcat(msgstr, tmsgstr);        /* catenate strings */
  }
#endif

  return(msgstr);
}

