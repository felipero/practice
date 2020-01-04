package felipero.amazon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class ClustersTest {
  @Test
  void testNumberAmazonGoStores() {
    List<List<Integer>> grid = mountGrid("1,1,0,0\n0,0,1,0\n0,0,0,0\n1,0,1,1\n1,1,1,1");
    assertEquals(3, new Clusters().numberAmazonGoStores(5, 4, grid));
  }

  @Test
  void testNumberAmazonGoStores_with_empty_matrix() {
    List<List<Integer>> grid = mountGrid("");
    assertEquals(0, new Clusters().numberAmazonGoStores(0, 0, grid));
  }

  @Test
  void testNumberAmazonGoStores_with_single_row_matrix() {
    List<List<Integer>> grid = mountGrid("1,1,0,1");
    assertEquals(2, new Clusters().numberAmazonGoStores(1, 4, grid));
  }

  @Test
  void testNumberAmazonGoStores_with_single_column_matrix() {
    List<List<Integer>> grid = mountGrid("1\n1\n0\n1");
    assertEquals(2, new Clusters().numberAmazonGoStores(4, 1, grid));
  }

  @Test
  void testNumberAmazonGoStores_with_no_cluster_matrix() {
    List<List<Integer>> grid = mountGrid("0,0\n0,0\n0,0\n0,0");
    assertEquals(0, new Clusters().numberAmazonGoStores(4, 2, grid));
  }

  @Test
  void testNumberAmazonGoStores_with_all_blocks_in_one_cluster() {
    List<List<Integer>> grid = mountGrid("1,1\n1,1\n1,1\n1,1");
    assertEquals(1, new Clusters().numberAmazonGoStores(4, 2, grid));
  }

  @Test
  void testNumberAmazonGoStores_with_a_single_block() {
    List<List<Integer>> grid = mountGrid("1");
    assertEquals(1, new Clusters().numberAmazonGoStores(1, 1, grid));
  }

  @Test
  void testNumberAmazonGoStores_with_a_single_zero_block() {
    List<List<Integer>> grid = mountGrid("0");
    assertEquals(0, new Clusters().numberAmazonGoStores(1, 1, grid));
  }

  @Test
  void testNumberAmazonGoStores_with_snake_blocks() {
    List<List<Integer>> grid = mountGrid("0,0,0,1\n0,0,1,1\n0,1,1,0\n1,1,0,0");
    assertEquals(1, new Clusters().numberAmazonGoStores(4, 4, grid));
  }

  List<List<Integer>> mountGrid(String matrix) {
    List<List<Integer>> grid = new ArrayList<List<Integer>>();

    if (matrix == "")
      return grid;

    String[] rows = matrix.split("\n");

    for (String rowS : rows) {
      int[] rowArray = Stream.of(rowS.split(",")).mapToInt(Integer::parseInt).toArray();
      List<Integer> row = new ArrayList<Integer>();

      for (int block : rowArray)
        row.add(block);

      grid.add(row);
    }

    return grid;
  }
}