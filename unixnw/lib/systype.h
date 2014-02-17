/*
 * Figure out the type of system that we're running on.
 *
 * Try to determine the environment automatically from the C compiler's
 * predefined symbols.
 * The following can be determined automatically:
 * BSD VAX, Pyramid, Xenix, AT&T 3b1, AT&T 80386, Celerity and MS-DOS.
 * If this doesn't work on some new system, ifdef this out, and set it
 * by hand.
 */

