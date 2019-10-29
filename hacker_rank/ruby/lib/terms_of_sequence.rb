# frozen_string_literal: true

# https://www.hackerrank.com/challenges/ruby-enumerable-reduce/problem

class TermsOfSequence
  def self.sum_terms(n_of_terms)
    (1..n_of_terms).inject(0) { |sum, n| sum + n**2 + 1 }
  end
end
