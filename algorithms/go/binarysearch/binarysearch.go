package binarysearch

func Search(array []string, target string) (string, int, int) {
	high := len(array) - 1
	return search(array, target, 0, high, 0)
}

func search(array []string, target string, low, high int, steps int) (guess string, idx int, stps int) {
	idx = (low + high) / 2
	guess = array[idx]
	stps = steps + 1

	if guess < target {
		return search(array, target, idx+1, high, stps)
	} else if guess > target {
		return search(array, target, low, idx-1, stps)
	}
	return
}
