package binarysearch

import "testing"

type Result struct {
	guess string
	index int
	steps int
}

func TestSearch(t *testing.T) {
	array := []string{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q"}

	igot := Result{}
	igot.guess, igot.index, igot.steps = Search(array, "a")
	assertResult("a", 0, 4, igot, t)

	pgot := Result{}
	pgot.guess, pgot.index, pgot.steps = Search(array, "i")
	assertResult("i", 8, 1, pgot, t)

	ggot := Result{}
	ggot.guess, ggot.index, ggot.steps = Search(array, "g")
	assertResult("g", 6, 4, ggot, t)
}

func assertResult(guess string, index int, steps int, got Result, t *testing.T) {
	if got.guess != guess {
		t.Errorf("got guess '%s' want '%s'", got.guess, guess)
	} else if got.index != index {
		t.Errorf("got index '%d' want '%d'", got.index, index)
	} else if got.steps != steps {
		t.Errorf("got steps '%d' want '%d'", got.steps, steps)
	}
}
