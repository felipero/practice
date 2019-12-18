# frozen_string_literal: true

require './lib/prime'

RSpec.describe Prime do
  describe '.prime?' do
    it { expect(described_class.prime?(1)).to be false }
    it { expect(described_class.prime?(2)).to be true }
    it { expect(described_class.prime?(3)).to be true }
    it { expect(described_class.prime?(40)).to be false }
    it { expect(described_class.prime?(11)).to be true }
    it { expect(described_class.prime?(69)).to be false }
    it { expect(described_class.prime?(71)).to be true }
    it { expect(described_class.prime?(97)).to be true }
    it { expect(described_class.prime?(25)).to be false }
    it { expect(described_class.prime?(-2)).to be true }
    it { expect(described_class.prime?(-20)).to be false }
    it { expect(described_class.prime?(15_485_857)).to be true }
  end
end
