# frozen_string_literal: true

class HourGlass
  def self.max_sum(arr)
    sum(arr).max
  end

  def self.sum(arr)
    (0..3).map do |row_idx|
      (0..3).map do |position|
        extract(arr, position, row_idx).reduce(:+)
      end
    end.flatten
  end

  def self.extract(arr, position = 0, start_row = 0)
    return [] unless (0..3).cover?(position) && (0..3).cover?(start_row)

    row = arr[start_row]
    edge_range = (position..position + 2)

    hourglass_top = row[edge_range]
    hourglass_middle = arr[start_row + 1][position + 1]
    hourglass_bottom = arr[start_row + 2][edge_range]

    [hourglass_top, hourglass_middle, hourglass_bottom].flatten
  end
end
