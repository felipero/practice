package felipero.heaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RunningMedianTest {
	@Test
	void testRunningMedian() {
		String input = "6\n12\n4\n5\n3\n8\n7";
		String output = "12.0\n8.0\n5.0\n4.5\n5.0\n6.0";
		assertEquals(output, RunningMedian.execute(input));
	}

	@Test
	void testRunningMedian_starting_with_low_numbers() {
		String input = "6\n2\n1\n15\n23\n28\n37";
		String output = "2.0\n1.5\n2.0\n8.5\n15.0\n19.0";
		assertEquals(output, RunningMedian.execute(input));
	}

	@Test
	void testMedianHeap() {
		MedianHeap mh = new MedianHeap();
		mh.add(2);
		assertEquals(2d, mh.getMedian());

		mh.add(1);
		assertEquals(1.5d, mh.getMedian());

		mh.add(15);
		assertEquals(2.0d, mh.getMedian());

		mh.add(23);
		assertEquals(8.5d, mh.getMedian());

		mh.add(28);
		assertEquals(15.0d, mh.getMedian());

		mh.add(37);
		assertEquals(19.0d, mh.getMedian());
	}
}
