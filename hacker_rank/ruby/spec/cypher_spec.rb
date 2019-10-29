# frozen_string_literal: true

require './lib/cypher'

RSpec.describe Cypher do
  describe '.rot13' do
    it 'returns all a-z chars rotated by 13 positions' do
      input = ['Why did the chicken cross the road?', 'Gb trg gb gur bgure fvqr!']
      output = ['Jul qvq gur puvpxra pebff gur ebnq?', 'To get to the other side!']
      expect(described_class.rot13(input)).to eq(output)
    end
  end
end
