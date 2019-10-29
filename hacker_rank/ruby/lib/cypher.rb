# frozen_string_literal: true

class Cypher
  def self.rot13(secret_messages)
    secret_messages.map { |msg| msg.tr('A-Za-z', 'N-ZA-Mn-za-m') }
  end
end
