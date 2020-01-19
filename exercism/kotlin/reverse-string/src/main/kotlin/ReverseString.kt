fun reverse(input: String): String {
	var result = ""
	for (c in input) result = c + result
	return result
}
