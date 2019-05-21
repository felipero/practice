defmodule BinarysearchTest do
  use ExUnit.Case
  doctest BinarySearch

  test "search below the middle" do
    assert BinarySearch.search(
             [
               "a",
               "b",
               "c",
               "d",
               "e",
               "f",
               "g",
               "h",
               "i",
               "j",
               "k",
               "l",
               "m",
               "n",
               "o",
               "p",
               "q"
             ],
             "a"
           ) == {"a", 0, 4}
  end

  test "search above the middle" do
    assert BinarySearch.search(
             ["a", "b", "c", "d", "e", "f", "g", "h", "i"],
             "i"
           ) == {"i", 8, 2}
  end
end
