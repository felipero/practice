// Package leap calculate if an specific year is leap or not
package leap

// IsLeapYear calculates if the given year is leap or not
func IsLeapYear(year int) bool {
	return year%4 == 0 && (year%100 != 0 || year%400 == 0)
}
