import java.util.Optional;

class Twofer {
    String twofer(String name) {
	    String nameValue = Optional.ofNullable(name).orElse("you");
	    return "One for " + nameValue + ", one for me.";
    }
}
