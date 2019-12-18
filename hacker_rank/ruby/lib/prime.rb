# frozen_string_literal: true

class Prime
  def self.prime?(num)
    num = num.abs
    return num > 1 if num <= 3
    return false if num.even? || (num % 3 == 0)

    factor = 5
    while factor <= Math.sqrt(num)
      return false if num % factor == 0 || num % (factor + 2) == 0

      factor += 6
    end
    true
  end
end
