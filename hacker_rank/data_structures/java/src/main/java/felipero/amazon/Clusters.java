package felipero.amazon;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Clusters {
  Integer rows = 0;
  Integer cols = 0;
  List<List<Integer>> grid = new ArrayList<List<Integer>>();
  Map<String, String> processed = new HashMap<String, String>();
  Set<String> clusters = new HashSet<String>();

  String checkBlock(int row, int col) {
    String cluster = processed.get(row + "," + col);
    if (cluster != null)
      return cluster;

    cluster = "";
    processed.put(row + "," + col, cluster);

    List<Integer> colList = grid.get(row);
    Integer current = colList.get(col);

    if (current == 1) {
      if (row > 0) {
        cluster = checkBlock(row - 1, col);
      }

      if (cluster == "" && col > 0) {
        cluster = checkBlock(row, col - 1);
      }

      if (cluster == "" && col + 1 < cols) {
        cluster = checkBlock(row, col + 1);
      }

      if (cluster == "" && row + 1 < rows) {
        cluster = checkBlock(row + 1, col);
      }

      cluster = cluster != "" ? cluster : row + "," + col;
      clusters.add(cluster);
    }

    processed.put(row + "," + col, cluster);
    return cluster;
  }

  int numberAmazonGoStores(int rows, int columns, List<List<Integer>> grid) {
    this.rows = rows;
    this.cols = columns;
    this.grid = grid;

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
        checkBlock(row, col);
      }
    }
    return clusters.size();
  }
}