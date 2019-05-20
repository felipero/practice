pub fn search(array: &[&'static str], target: &str) -> Option<(&'static str, usize, u32)> {
  let mut steps: u32 = 0;
  let mut low: usize = 0;
  let mut high: usize = array.len() - 1;
  let res: (&'static str, usize, u32);

  while low <= high {
    let middle: usize = (high - low) / 2 + low;
    let guess = array[middle];
    steps += 1;
    if guess == target {
      res = (guess, middle, steps);
      return Some(res);
    } else if guess < target {
      low = middle + 1;
    } else if guess > target {
      high = middle - 1;
    }
  }
  return None;
}

#[cfg(test)]
mod test_binary_search;
