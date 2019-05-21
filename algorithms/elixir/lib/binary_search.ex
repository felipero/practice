defmodule BinarySearch do
  def search(list, target) do
    array = :array.from_list(list)
    high = :array.size(array) - 1
    search(array, target, 0, high)
  end

  defp search(array, target, low, high, steps \\ 0) do
    idx = Kernel.round((low + high) / 2)
    guess = :array.get(idx, array)

    case {guess} do
      {guess} when guess == target ->
        {guess, idx, steps}

      {guess} when guess > target ->
        search(array, target, low, idx - 1, steps + 1)

      {guess} when guess < target ->
        search(array, target, idx + 1, high, steps + 1)
    end
  end
end
