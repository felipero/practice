package felipero.codility.arrays

import org.scalatest._

class CycleRotationSpec extends FlatSpec with Matchers {
  "CycleRotation.rotate" should "rotate the given array by k positions" in {
   CycleRotation.rotate(Array[Int](1, 2, 3, 4, 5), 2) shouldEqual Array[Int](4, 5, 1, 2, 3)
  }

  "CycleRotation.rotate with k bigger than arrSize/2" should "rotate the given array by k positions" in {
   CycleRotation.rotate(Array[Int](1, 2, 3, 4, 5), 3) shouldEqual Array[Int](3, 4, 5, 1, 2)
  }

  "CycleRotation.rotate with k equal arrSize" should "rotate the given array by k positions" in {
   CycleRotation.rotate(Array[Int](1, 2, 3, 4, 5), 5) shouldEqual Array[Int](1, 2, 3, 4, 5)
  }

  "CycleRotation.rotate with k bigger than arrSize" should "rotate the given array by k positions" in {
   CycleRotation.rotate(Array[Int](1, 2, 3, 4, 5), 6) shouldEqual Array[Int](5, 1, 2, 3, 4)
  }

  "CycleRotation.rotate with k six times arrSize plus 1" should "rotate the given array by k positions" in {
   CycleRotation.rotate(Array[Int](1, 2, 3, 4, 5), 26) shouldEqual Array[Int](5, 1, 2, 3, 4)
  }

  "CycleRotation.rotate with empty array" should "rotate the given array by k positions" in {
   CycleRotation.rotate(Array[Int](), 2) shouldEqual Array[Int]()
  }

  "CycleRotation.rotate with single element array" should "rotate the given array by k positions" in {
   CycleRotation.rotate(Array[Int](1), 2) shouldEqual Array[Int](1)
  }
}
