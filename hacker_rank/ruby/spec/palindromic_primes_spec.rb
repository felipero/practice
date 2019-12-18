# frozen_string_literal: true

require './lib/palindromic'

RSpec.describe Palindromic do
  describe '.palindromic_prime?' do
    it { expect(described_class.palindromic_prime?(1)).to be false }
    it { expect(described_class.palindromic_prime?(2)).to be true }
    it { expect(described_class.palindromic_prime?(3)).to be true }
    it { expect(described_class.palindromic_prime?(44)).to be false }
    it { expect(described_class.palindromic_prime?(101)).to be true }
    it { expect(described_class.palindromic_prime?(121)).to be false }
    it { expect(described_class.palindromic_prime?(131)).to be true }
    it { expect(described_class.palindromic_prime?(97)).to be false }
    it { expect(described_class.palindromic_prime?(-2)).to be true }
    it { expect(described_class.palindromic_prime?(-131)).to be true }
  end
end
