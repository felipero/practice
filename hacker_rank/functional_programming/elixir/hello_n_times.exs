defmodule Recursion do
  def print_multiple_times(msg, n) when n <= 1 do
    IO.puts msg
  end

  def print_multiple_times(msg, n) do
    IO.puts msg
    print_multiple_times(msg, n - 1)
  end
end

n = String.to_integer(String.trim(IO.gets ""))
Recursion.print_multiple_times("Hello World", 3)
