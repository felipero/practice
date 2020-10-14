package felipero.graphs

import org.scalatest._
import scala.io.Source

class BFSShortestReachSpec extends FlatSpec with Matchers {
  "execute" should "return the distance for each node" in {
    val input =
      """2
4 2
1 2
1 3
1
3 1
2 3
2"""

    BFSShortestReach.execute(input) shouldEqual "6 6 -1\n-1 6"
  }

//   "execute with weird test input" should "return the distance for each node" in {
//     val input =
//       """1
// 10 6
// 3 1
// 10 1
// 10 1
// 3 1
// 1 8
// 5 2
// 3"""
//     BFSShortestReach.execute(input) shouldEqual "6 -1 -1 -1 -1 -1 12 -1 12"
//   }

  // "execute with very large input" should "return the distance for each node" in {
  //   val input = Source.fromResource("input_case5.txt").getLines.mkString("\n")
  //   val output = Source.fromResource("output_case5.txt").getLines.mkString("\n")
  //   BFSShortestReach.execute(input) shouldEqual output
  // }
}
