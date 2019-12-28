#include "reverse_string.h"
#include <string>

namespace reverse_string {

	std::string reverse_string(std::string input) {
		std::string reverse("");

		for(char & c : input){
	          reverse.insert(reverse.cbegin(), c);
		}
		return reverse;
	}
}  // namespace reverse_string
