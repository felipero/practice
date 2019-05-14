defmodule Solution do
  def rep([head | tail], n) do
    List.flatten [List.duplicate(head, n) | rep(tail, n)]
  end

  def rep([], n) do
    []
  end
end

n = String.to_integer(String.trim(IO.gets ""))
res = IO.read(:all)
list = String.split(res, "\n")
b = Enum.map(list, &String.to_integer/1)
Solution.rep(b, n)
|> Enum.map(fn(x) -> IO.puts(x) end)
