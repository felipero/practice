# frozen_string_literal: true

require './lib/2d_array/hour_glass.rb'

RSpec.describe HourGlass do
  describe '.max_sum' do
    let(:arr) do
      [
        [-9, -9, -9, 1, 1, 1],
        [0, -9, 0, 4, 3, 2],
        [-9, -9, -9, 1, 2, 3],
        [0,  0,  8, 6, 6, 0],
        [0,  0,  0, -2, 0, 0],
        [0,  0,  1,  2, 4, 0]
      ]
    end

    it { expect(described_class.max_sum(arr)).to eq 28 }
  end

  describe '.sum' do
    let(:arr) do
      [
        [-9, -9, -9, 1, 1, 1],
        [0, -9, 0, 4, 3, 2],
        [-9, -9, -9, 1, 2, 3],
        [0,  0,  8, 6, 6, 0],
        [0,  0,  0, -2, 0, 0],
        [0,  0,  1,  2, 4, 0]
      ]
    end

    it { expect(described_class.sum(arr)).to eq [-63, -34, -9, 12, -10, 0, 28, 23, -27, -11, -2, 10, 9, 17, 25, 18] }
  end

  describe '.extract' do
    let(:arr) do
      [
        [1, 2, 3, 4, 5, 6],
        [3, 4, 5, 6, 7, 8],
        [5, 6, 7, 8, 9, 0],
        [7, 8, 9, 0, 1, 2],
        [9, 0, 1, 2, 3, 4],
        [1, 2, 3, 4, 5, 6]
      ]
    end

    it { expect(described_class.extract(arr, -1)).to eq [] }
    it { expect(described_class.extract(arr)).to eq [1, 2, 3, 4, 5, 6, 7] }
    it { expect(described_class.extract(arr, 1)).to eq [2, 3, 4, 5, 6, 7, 8] }
    it { expect(described_class.extract(arr, 2)).to eq [3, 4, 5, 6, 7, 8, 9] }
    it { expect(described_class.extract(arr, 3)).to eq [4, 5, 6, 7, 8, 9, 0] }
    it { expect(described_class.extract(arr, 4)).to eq [] }
    it { expect(described_class.extract(arr, 0, 1)).to eq [3, 4, 5, 6, 7, 8, 9] }
    it { expect(described_class.extract(arr, 1, 1)).to eq [4, 5, 6, 7, 8, 9, 0] }
    it { expect(described_class.extract(arr, 2, 2)).to eq [7, 8, 9, 0, 1, 2, 3] }
    it { expect(described_class.extract(arr, 3, 3)).to eq [0, 1, 2, 3, 4, 5, 6] }
    it { expect(described_class.extract(arr, 0, 4)).to eq [] }
  end
end
