defmodule Solution do
  def read() do
    case IO.read(:stdio, :all) do
      :eof -> :ok
      {:error, _} -> IO.puts "Seriously, FUUUUUUUUUU (ಠ_ಠ)┌∩┐"
      data -> data |> String.split("\n")
    end
  end

  def filter_array(n, [head | tail]) when head < n do
    List.flatten [head | filter_array(n, tail)]
  end

  def filter_array(n, [head | tail]) when head >= n do
    filter_array(n, tail)
  end

  def filter_array(_, []), do: []
end

n = IO.read(:stdio, :line) |> String.trim |> String.to_integer
array = Enum.map(Solution.read(), &String.to_integer/1)
Enum.each Solution.filter_array(n, array), &IO.puts(&1)
