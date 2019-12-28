pub fn reverse(input: &str) -> String {
    let mut reverse = String::from("");

    for c in input.chars() {
        reverse.insert(0, c);
    }
    return reverse;
}
