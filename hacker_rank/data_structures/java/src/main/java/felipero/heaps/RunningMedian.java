/*
 * Solution for HackerRank problem Balanced Brackets:
 * check https://www.hackerrank.com/challenges/find-the-running-median/problem
 */
package felipero.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class MedianHeap {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    private Double median;

    private static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i, Integer j) {
            return i > j ? -1 : i == j ? 0 : 1;
        }
    }

    public MedianHeap() {
        this.maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
        this.minHeap = new PriorityQueue<Integer>();
    }

    public Double getMedian() {
        return this.median;
    }

    void add(Integer newMember) {
        if (isEmpty())
            minHeap.add(newMember);
        else {
            if (newMember <= this.getMedian())
                maxHeap.add(newMember);
            else
                minHeap.add(newMember);
        }

        if (Math.abs(maxHeap.size() - minHeap.size()) > 1)
            balanceHeaps();

        updateMedian();
    }

    private void balanceHeaps() {
        if (maxHeap.size() > minHeap.size())
            minHeap.add(maxHeap.poll());
        else
            maxHeap.add(minHeap.poll());
    }

    private void updateMedian() {
        if (maxHeap.size() == minHeap.size())
            this.median = ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
        else if (maxHeap.size() > minHeap.size())
            this.median = (double) maxHeap.peek();
        else
            this.median = (double) minHeap.peek();
    }

    Boolean isEmpty() {
        return minHeap.isEmpty() && maxHeap.isEmpty();
    }
}

public class RunningMedian {

    static double[] runningMedian(int[] a) {

        MedianHeap heap = new MedianHeap();

        double[] results = new double[a.length];

        for (int i = 0; i < a.length; ++i) {
            heap.add(a[i]);
            results[i] = heap.getMedian();
        }

        return results;
    }

    public static String execute(String input) {
        Scanner scanner = new Scanner(input);

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        scanner.close();

        double[] result = runningMedian(a);

        String output = "";
        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            output += String.valueOf(result[resultItr]);

            if (resultItr != result.length - 1) {
                output += "\n";
            }
        }

        return output;
    }
}
