package main

import (
	"fmt"
)

/* n is package variable */
var n = 100

func main() {
	/* increment package variable n, and display */
	n = n + 1
	fmt.Printf("n=%d\n", n)
}
