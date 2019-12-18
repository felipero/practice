# frozen_string_literal: true

require 'prime'

class Palindromic
  def self.palindromic_prime?(n)
    str_n = n.abs.to_s
    str_n == str_n.reverse && Prime.prime?(n)
  end
end
