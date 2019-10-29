# frozen_string_literal: true

# https://www.hackerrank.com/challenges/ruby-enumerable-collect/problem

class Cypher
  def self.rot13(secret_messages)
    secret_messages.map { |msg| msg.tr('A-Za-z', 'N-ZA-Mn-za-m') }
  end
end
