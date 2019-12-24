// Package twofer implements a simple two for one function.
// Two-fer or 2-fer is short for two for one. One for you and one for me.
package twofer

import "fmt"

// ShareWith receives a name string and returns the two fer sentence.
func ShareWith(name string) string {
	if name == "" {
		name = "you"
	}
	return fmt.Sprintf("One for %s, one for me.", name)

}
