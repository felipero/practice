use unicode_segmentation::UnicodeSegmentation as us;

pub fn reverse(input: &str) -> String {
    us::graphemes(input, true).rev().collect()
}
