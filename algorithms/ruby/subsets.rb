def subset?(needles, haystack)
  return true if needles.empty?
  
  needles_frequencies = count_element_frequencies(needles)
  haystack_frequencies = count_element_frequencies(haystack)
  
  needles_frequencies.all? {|el, count| haystack_frequencies[el] >= count }
end

def count_element_frequencies(array)
  res = Hash.new(0)
  array.each{|el| res[el] = res[el] + 1  }
  res
end

require 'rspec/autorun'

RSpec.describe "subset?" do
  it 'should return true for an empty set' do
    needles  = []
    haystack = %w[a b c]
    expect(subset?(needles, haystack)).to eq(true)
  end

  it 'should return true if in haystack' do
    needles  = %w[a]
    haystack = %w[a]
    expect(subset?(needles, haystack)).to eq(true)
  end

  it 'should return false if not in haystack' do
    needles  = %w[a]
    haystack = %w[b]
    expect(subset?(needles, haystack)).to eq(false)
  end

  it 'should return true if in different order' do
    needles  = %w[a b c]
    haystack = %w[b a c]
    expect(subset?(needles, haystack)).to eq(true)
  end

  it 'should return false if haystack smaller' do
    needles  = %w[a b c]
    haystack = %w[a b]
    expect(subset?(needles, haystack)).to eq(false)
  end

  it 'should return true if extra values' do
    needles  = %w[a b c]
    haystack = %w[b q r n a c]
    expect(subset?(needles, haystack)).to eq(true)
  end

  it 'should return false if missing one value' do
    needles  = %w[a b c]
    haystack = %w[q r n a c]
    expect(subset?(needles, haystack)).to eq(false)
  end

  it 'should return false if not enough of the multiple value' do
    needles  = %w[a a b c]
    haystack = %w[b q r n a c]
    expect(subset?(needles, haystack)).to eq(false)
  end

  it 'should return true if more of multiple value' do
    needles  = %w[a a b c]
    haystack = %w[b a a a c]
    expect(subset?(needles, haystack)).to eq(true)
  end
end