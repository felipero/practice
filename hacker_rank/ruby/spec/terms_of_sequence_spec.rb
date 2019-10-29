# frozen_string_literal: true

require './lib/terms_of_sequence'

RSpec.describe TermsOfSequence do
  describe '.sum_terms' do
    context 'with positive number of terms sum terms from a sequence which reason is t(n) = n**2 + 1' do
      it { expect(described_class.sum_terms(2)).to eq 7 }
      it { expect(described_class.sum_terms(4)).to eq 34 }
      it { expect(described_class.sum_terms(25)).to eq 5550 }
    end
  end
end
